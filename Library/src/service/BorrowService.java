
package service;

import model.Book;
import model.Member;
import model.BorrowRecord;
import repository.BookRepository;
import repository.MemberRepository;
import repository.BorrowRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class BorrowService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BorrowRepository borrowRepository;

    public BorrowService(BookRepository bookRepository,
                         MemberRepository memberRepository,
                         BorrowRepository borrowRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.borrowRepository = borrowRepository;
    }

    public boolean borrowBook(int memberId, int bookId) {

        Member member = memberRepository.findById(memberId);
        Book book = bookRepository.findById(bookId);

        if (member == null || book == null) {
            return false;
        }

        ArrayList<BorrowRecord> activeRecords =
                borrowRepository.findActiveByMemberId(memberId);

        if (activeRecords.size() >= 3) {
            return false;
        }

        if (book.getAvailableCopies() <= 0) {
            return false;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        LocalDate borrowDate = LocalDate.now();
        LocalDate dueDate = borrowDate.plusDays(14);

        BorrowRecord record = new BorrowRecord(
                borrowRepository.generateId(),
                memberId,
                bookId,
                borrowDate,
                dueDate
        );

        borrowRepository.addRecord(record);

        return true;
    }

    public boolean returnBook(int recordId) {

        BorrowRecord record = borrowRepository.findById(recordId);

        if (record == null || record.isReturned()) {
            return false;
        }

        Book book = bookRepository.findById(record.getBookId());

        if (book == null) {
            return false;
        }

        record.setReturnDate(LocalDate.now());

        book.setAvailableCopies(book.getAvailableCopies() + 1);

        return true;
    }

    public ArrayList<BorrowRecord> getAllRecords() {
        return borrowRepository.getAllRecords();
    }

    public ArrayList<BorrowRecord> getActiveRecords() {
        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : borrowRepository.getAllRecords()) {
            if (!record.isReturned()) {
                result.add(record);
            }
        }

        return result;
    }

    public ArrayList<BorrowRecord> getOverdueRecords() {
        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : borrowRepository.getAllRecords()) {
            if (record.isOverdue()) {
                result.add(record);
            }
        }

        return result;
    }
}


package service;

import model.Book;
import model.Member;
import model.BorrowRecord;

import repository.BookRepository;
import repository.MemberRepository;
import repository.BorrowRepository;

import java.util.ArrayList;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Comparator;

public class ReportService {

    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final BorrowRepository borrowRepository;

    public ReportService(BookRepository bookRepository,
                         MemberRepository memberRepository,
                         BorrowRepository borrowRepository) {

        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.borrowRepository = borrowRepository;
    }


    public ArrayList<Map.Entry<Book, Integer>> getMostBorrowedBooks() {

        ArrayList<Map.Entry<Book, Integer>> result = new ArrayList<>();

        for (Book book : bookRepository.getAllBooks()) {

            int count = 0;

            for (BorrowRecord record : borrowRepository.getAllRecords()) {

                if (record.getBookId() == book.getId()) {
                    count++;
                }
            }

            if (count > 0) {
                result.add(new AbstractMap.SimpleEntry<>(book, count));
            }
        }

        result.sort(
                Map.Entry.<Book, Integer>comparingByValue(
                        Comparator.reverseOrder())
        );

        return result;
    }


    public ArrayList<BorrowRecord> getCurrentlyBorrowedBooks() {

        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : borrowRepository.getAllRecords()) {

            if (!record.isReturned()) {
                result.add(record);
            }
        }

        return result;
    }


    public ArrayList<BorrowRecord> getOverdueBooks() {

        ArrayList<BorrowRecord> result = new ArrayList<>();

        for (BorrowRecord record : borrowRepository.getAllRecords()) {

            if (record.isOverdue()) {
                result.add(record);
            }
        }

        return result;
    }


    public ArrayList<Book> filterByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }


    public ArrayList<Book> filterByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }


    public ArrayList<Map.Entry<Member, Integer>> getMostActiveMembers() {

        ArrayList<Map.Entry<Member, Integer>> result = new ArrayList<>();

        for (Member member : memberRepository.getAllMembers()) {

            int count = 0;

            for (BorrowRecord record : borrowRepository.getAllRecords()) {

                if (record.getMemberId() == member.getId()) {
                    count++;
                }
            }

            if (count > 0) {
                result.add(new AbstractMap.SimpleEntry<>(member, count));
            }
        }

        result.sort(
                Map.Entry.<Member, Integer>comparingByValue(
                        Comparator.reverseOrder())
        );

        return result;
    }

    public Book findBookById(int id) {
        return bookRepository.findById(id);
    }

    public Member findMemberById(int id) {
        return memberRepository.findById(id);
    }
}

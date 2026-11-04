
package model;

import java.time.LocalDate;

public class BorrowRecord {

    private final int id;
    private final int memberId;
    private final int bookId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(int id, int memberId, int bookId,
                        LocalDate borrowDate, LocalDate dueDate) {
        this.id = id;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public boolean isOverdue() {
        return !isReturned() && LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return "Qeyd ID: " + id
                + " | Uzv ID: " + memberId
                + " | Kitab ID: " + bookId
                + " | Goturulme: " + borrowDate
                + " | Son tarix: " + dueDate
                + " | Qaytarilma: "
                + (returnDate == null ? "Qaytarilmayib" : returnDate);
    }
}

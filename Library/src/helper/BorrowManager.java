
package helper;

import model.BorrowRecord;
import service.BorrowService;

import java.util.ArrayList;

public class BorrowManager {

    private final BorrowService borrowService;
    private final InputHelper input;

    public BorrowManager(BorrowService borrowService,
                         InputHelper input) {
        this.borrowService = borrowService;
        this.input = input;
    }

    public void borrowBook() {

        int memberId = input.readInt("Uzvun ID-si: ");
        int bookId = input.readInt("Kitabin ID-si: ");

        if (borrowService.borrowBook(memberId, bookId)) {
            System.out.println("Kitab ugurla goturuldu!");
            System.out.println("Qaytarilma muddeti: 14 gun.");
        } else {
            System.out.println("Emeliyyat ugursuzdur!");
            System.out.println("Uzv, kitab, nüsxe sayi ve limit yoxlanilmalidir.");
        }
    }

    public void returnBook() {

        int recordId = input.readInt("Götürme qeydinin ID-si: ");

        if (borrowService.returnBook(recordId)) {
            System.out.println("Kitab ugurla qaytarildi!");
        } else {
            System.out.println("Qeyd tapilmadi veya kitab artiq qaytarilib!");
        }
    }

    public void showActiveRecords() {
        showRecords(borrowService.getActiveRecords());
    }

    public void showOverdueRecords() {
        showRecords(borrowService.getOverdueRecords());
    }

    public void showAllRecords() {
        showRecords(borrowService.getAllRecords());
    }

    private void showRecords(ArrayList<BorrowRecord> records) {

        if (records.isEmpty()) {
            System.out.println("Qeyd tapilmadi!");
            return;
        }

        for (BorrowRecord record : records) {
            System.out.println(record);

            if (record.isOverdue()) {
                System.out.println("GECIKME VAR!");
            }
        }
    }
}

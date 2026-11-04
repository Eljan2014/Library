
package helper;

import model.Book;
import model.Member;
import model.BorrowRecord;
import service.ReportService;

import java.util.ArrayList;
import java.util.Map;

public class ReportManager {

    private final ReportService reportService;
    private final InputHelper input;

    public ReportManager(ReportService reportService,
                         InputHelper input) {

        this.reportService = reportService;
        this.input = input;
    }

    public void showMostBorrowedBooks() {

        ArrayList<Map.Entry<Book, Integer>> books =
                reportService.getMostBorrowedBooks();

        if (books.isEmpty()) {
            System.out.println("Hele kitab goturulmeyib!");
            return;
        }

        System.out.println("\n===== EN COX GOTURULEN KITABLAR =====");

        int rank = 1;

        for (Map.Entry<Book, Integer> entry : books) {

            System.out.println(
                    rank++ + ". " + entry.getKey().getTitle()
                            + " | Goturulme sayi: " + entry.getValue()
            );
        }
    }


    public void showCurrentlyBorrowedBooks() {

        ArrayList<BorrowRecord> records =
                reportService.getCurrentlyBorrowedBooks();

        if (records.isEmpty()) {
            System.out.println("Hazirda goturulmus kitab yoxdur!");
            return;
        }

        System.out.println("\n===== UZVLERDE OLAN KITABLAR =====");

        for (BorrowRecord record : records) {

            Book book = reportService.findBookById(record.getBookId());
            Member member = reportService.findMemberById(record.getMemberId());

            System.out.println("--------------------------------");

            System.out.println("Qeyd ID: " + record.getId());

            System.out.println("Kitab: " +
                    (book == null ? "Tapilmadi" : book.getTitle()));

            System.out.println("Uzv: " +
                    (member == null ? "Tapilmadi" : member.getName()));

            System.out.println("Goturulme tarixi: " + record.getBorrowDate());
            System.out.println("Son qaytarilma tarixi: " + record.getDueDate());
        }
    }


    public void showOverdueBooks() {

        ArrayList<BorrowRecord> records =
                reportService.getOverdueBooks();

        if (records.isEmpty()) {
            System.out.println("Gecikmis kitab yoxdur!");
            return;
        }

        System.out.println("\n===== GECIKMIS KITABLAR =====");

        for (BorrowRecord record : records) {

            Book book = reportService.findBookById(record.getBookId());
            Member member = reportService.findMemberById(record.getMemberId());

            System.out.println("--------------------------------");

            System.out.println("Qeyd ID: " + record.getId());

            System.out.println("Kitab: " +
                    (book == null ? "Tapilmadi" : book.getTitle()));

            System.out.println("Uzv: " +
                    (member == null ? "Tapilmadi" : member.getName()));

            System.out.println("Son tarix: " + record.getDueDate());
            System.out.println("GECIKME VAR!");
        }
    }


    public void filterByGenre() {

        String genre = input.readText("Janr daxil edin: ");

        ArrayList<Book> books =
                reportService.filterByGenre(genre);

        showBooks(books);
    }


    public void filterByAuthor() {

        String author = input.readText("Muellif daxil edin: ");

        ArrayList<Book> books =
                reportService.filterByAuthor(author);

        showBooks(books);
    }


    public void showMostActiveMembers() {

        ArrayList<Map.Entry<Member, Integer>> members =
                reportService.getMostActiveMembers();

        if (members.isEmpty()) {
            System.out.println("Aktiv uzv yoxdur!");
            return;
        }

        System.out.println("\n===== EN AKTIV KITABXANA UZVLERI =====");

        int rank = 1;

        for (Map.Entry<Member, Integer> entry : members) {

            System.out.println(
                    rank++ + ". " + entry.getKey().getName()
                            + " | Goturduyu kitablar: " + entry.getValue()
            );
        }
    }

    private void showBooks(ArrayList<Book> books) {

        if (books.isEmpty()) {
            System.out.println("Kitab tapilmadi!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}

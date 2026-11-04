
package helper;

import model.Book;
import service.BookService;

import java.util.ArrayList;

public class BookManager {

    private BookService bookService;
    private helper.InputHelper input;

    public BookManager(BookService bookService,
                       helper.InputHelper input) {
        this.bookService = bookService;
        this.input = input;
    }

    public void addBook() {
        int id = input.readInt("Kitabin ID-si: ");
        String title = input.readText("Kitabin adi: ");
        String author = input.readText("Muellif: ");
        String genre = input.readText("Janr: ");
        int copies = input.readInt("Nusxe sayi: ");

        Book book = new Book(
                id, title, author, genre, copies
        );

        if (bookService.addBook(book)) {
            System.out.println("Kitab elave edildi!");
        } else {
            System.out.println("Kitab elave edilmedi!");
        }
    }

    public void deleteBook() {
        int id = input.readInt("Silinecek kitabin ID-si: ");

        if (bookService.deleteBook(id)) {
            System.out.println("Kitab silindi!");
        } else {
            System.out.println("Kitab tapilmadi!");
        }
    }

    public void updateBook() {
        int id = input.readInt("Kitabin ID-si: ");

        Book book = bookService.findById(id);

        if (book == null) {
            System.out.println("Kitab tapilmadi!");
            return;
        }

        String title = input.readText("Yeni ad: ");
        String author = input.readText("Yeni muellif: ");
        String genre = input.readText("Yeni janr: ");
        int copies = input.readInt("Yeni umumi nusxe sayi: ");

        if (bookService.updateBook(
                id, title, author, genre, copies)) {
            System.out.println("Kitab yenilendi!");
        } else {
            System.out.println("Melumatlar yanlisdir!");
        }
    }

    public void searchById() {
        int id = input.readInt("Kitabin ID-si: ");

        Book book = bookService.findById(id);

        if (book == null) {
            System.out.println("Kitab tapilmadi!");
        } else {
            System.out.println(book);
        }
    }

    public void searchByTitle() {
        String title = input.readText("Kitabin adi: ");
        showResults(bookService.findByTitle(title));
    }

    public void searchByAuthor() {
        String author = input.readText("Muellif: ");
        showResults(bookService.findByAuthor(author));
    }

    public void searchByGenre() {
        String genre = input.readText("Janr: ");
        showResults(bookService.findByGenre(genre));
    }

    public void showAllBooks() {
        showResults(bookService.getAllBooks());
    }

    private void showResults(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Kitab tapilmadi!");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
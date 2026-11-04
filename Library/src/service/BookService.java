
package service;

import model.Book;
import repository.BookRepository;

import java.util.ArrayList;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addBook(Book book) {
        if (book == null
                || book.getId() <= 0
                || book.getTitle() == null
                || book.getTitle().trim().isEmpty()
                || book.getAuthor() == null
                || book.getAuthor().trim().isEmpty()
                || book.getGenre() == null
                || book.getGenre().trim().isEmpty()
                || book.getTotalCopies() <= 0) {
            return false;
        }

        if (bookRepository.findById(book.getId()) != null) {
            return false;
        }

        bookRepository.addBook(book);
        return true;
    }

    public boolean deleteBook(int id) {
        return bookRepository.deleteBook(id);
    }

    public boolean updateBook(int id, String title,
                              String author, String genre,
                              int totalCopies) {

        Book book = bookRepository.findById(id);

        if (book == null
                || title == null || title.trim().isEmpty()
                || author == null || author.trim().isEmpty()
                || genre == null || genre.trim().isEmpty()
                || totalCopies <= 0) {
            return false;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTotalCopies(totalCopies);

        return true;
    }

    public Book findById(int id) {
        return bookRepository.findById(id);
    }

    public ArrayList<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public ArrayList<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    public ArrayList<Book> findByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public ArrayList<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}

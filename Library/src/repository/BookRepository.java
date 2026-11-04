
package repository;

import model.Book;
import java.util.ArrayList;

public class BookRepository {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean deleteBook(int id) {
        Book book = findById(id);

        if (book == null) {
            return false;
        }

        books.remove(book);
        return true;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public ArrayList<Book> findByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    public ArrayList<Book> findByAuthor(String author) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().toLowerCase()
                    .contains(author.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    public ArrayList<Book> findByGenre(String genre) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    public ArrayList<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}

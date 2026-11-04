
package model;

public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    private int totalCopies;
    private int availableCopies;

    public Book(int id, String title, String author,
                String genre, int totalCopies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Ad: " + title
                + " | Müəllif: " + author
                + " | Janr: " + genre
                + " | Ümumi nüsxə: " + totalCopies
                + " | Mövcud nüsxə: " + availableCopies;
    }
}

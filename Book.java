package Library;

public class Book {
    private String title;
    private String authors;
    private int nCopies;
    private int hasEBook;

    public Book(String title, String authors, int nCopies, int hasEBook) {
        this.title = title;
        this.authors = authors;
        this.nCopies = nCopies;
        this.hasEBook = hasEBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getNCopies() {
        return nCopies;
    }

    public int getHasEBook() {
        return hasEBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setNCopies(int nCopies) {
        this.nCopies = nCopies;
    }

    public void setHasEBook(int hasEBook) {
        this.hasEBook = hasEBook;
    }

    @Override
    public String toString() {
        return this.title + " | " + this.authors + " | " + this.nCopies + " | " + this.hasEBook;
    }
}
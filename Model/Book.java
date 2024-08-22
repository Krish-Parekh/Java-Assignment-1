package Library.Model;



public class Book {
    private String title;
    private String authors;
    private int nCopies;
    private boolean hasEBook;

    public Book(String title, String authors, int nCopies, boolean hasEBook) {
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

    public boolean getHasEBook() {
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

    public void setHasEBook(boolean hasEBook) {
        this.hasEBook = hasEBook;
    }

    @Override
    public String toString() {
        String hasEBook = this.hasEBook ? "Yes" : "No";
        String nCopiesType = this.nCopies > 1 ? " copies" : " copy";
        return this.title + " | " + this.authors + " | " + this.nCopies + nCopiesType + " | " + hasEBook;
    }
}


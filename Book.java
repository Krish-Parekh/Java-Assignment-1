package Library;

public class Book {
    private String title;
    private String authors;
    private int nCopies;
    private boolean hasEBook;
    private double price;

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

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }


    @Override
    public String toString() {
        String hasEBook = this.hasEBook ? "Yes" : "No";
        return this.title + " | " + this.authors + " | " + this.nCopies + " | " + hasEBook;
    }
}

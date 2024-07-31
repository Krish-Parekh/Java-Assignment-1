package Library;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance = null;
    private List<Book> books;

    private Cart() {
        this.books = new ArrayList<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void removeAllBooks() {
        this.books.clear();
    }
}

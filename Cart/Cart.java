package Library.Cart;

import java.util.LinkedHashMap;
import java.util.ArrayList;

import Library.Enums.BookType;
import Library.Model.CartBook;

public class Cart {
    private static Cart instance = null;
    private LinkedHashMap<String, LinkedHashMap<BookType, ArrayList<CartBook>>> booksLookup;

    private Cart() {
        this.booksLookup = new LinkedHashMap<>();
    }

    public static Cart getInstance() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public LinkedHashMap<String, LinkedHashMap<BookType, ArrayList<CartBook>>> getBooksLookup() {
        return booksLookup;
    }

    public void addBook(CartBook cartBook) {
        String bookName = cartBook.getTitle();
        BookType bookType = cartBook.getBookType();
        if (!booksLookup.containsKey(bookName)) {
            booksLookup.put(bookName, new LinkedHashMap<>());
        }

        if (!booksLookup.get(bookName).containsKey(bookType)) {
            ArrayList<CartBook> newCartBookList = new ArrayList<>();
            newCartBookList.add(cartBook);
            booksLookup.get(bookName).put(bookType, newCartBookList);
        } else {
            if (bookType == BookType.PHYSICAL) {
                booksLookup.get(bookName).get(bookType).add(cartBook);
            }
        }
    }

    public void removeBook(CartBook cartBook) {
        String bookName = cartBook.getTitle();
        BookType bookType = cartBook.getBookType();
        if (booksLookup.containsKey(bookName) && booksLookup.get(bookName).containsKey(bookType)) {
            booksLookup.get(bookName).get(bookType).clear();

            if (booksLookup.get(bookName).get(bookType).isEmpty()) {
                booksLookup.get(bookName).remove(bookType);
            }
        }
    }

    public void removeAllBooks() {
        booksLookup.clear();
    }
}

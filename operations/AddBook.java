package Library.operations;

import Library.Book;
import Library.Cart;
import Library.interfaces.Operation;

public class AddBook implements Operation {
    private Book book;

    public AddBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        Cart.getInstance().addBook(book);
    }
}

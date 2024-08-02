package Library.operations;

import Library.interfaces.Operation;
import Library.Cart;
import Library.Book;

public class RemoveBook implements Operation {
    private Book book;

    public RemoveBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        Cart.getInstance().removeBook(book);
        System.out.println("Book removed from shopping cart: " + book.getTitle());
    }

}

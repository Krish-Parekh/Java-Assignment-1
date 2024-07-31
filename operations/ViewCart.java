package Library.operations;

import java.util.List;

import Library.Book;
import Library.interfaces.Operation;

public class ViewCart implements Operation {
    @Override
    public void execute() {
        List<Book> books = Cart.getInstance().getBooks();
        if (books.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Your shopping cart contains the following book(s):");
            for (int i = 0; i < books.length; i++) {
                int bookNumber = i + 1;
                System.out.println(bookNumber + ". " + books[i].getTitle());
            }
        }
    }

}

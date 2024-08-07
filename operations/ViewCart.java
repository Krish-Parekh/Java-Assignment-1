package Library.operations;

import java.util.List;

import Library.Cart;
import Library.Book;
import Library.interfaces.Operation;

public class ViewCart implements Operation {
    @Override
    public void execute() {
        List<Book> books = Cart.getInstance().getBooks();
        if (books.isEmpty()) {
            System.out.println("Your shopping cart is empty");
        } else {
            System.out.println("Your shopping cart contains the following book(s):");
            for (int i = 0; i < books.size(); i++) {
                int bookNumber = i + 1;
                System.out.println(bookNumber + ". " + books.get(i).getTitle());
            }
        }
    }

}

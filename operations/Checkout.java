package Library.operations;

import Library.interfaces.Operation;
import Library.Cart;
import Library.Book;
import java.util.List;

public class Checkout implements Operation {

    @Override
    public void execute() {
        List<Book> books = Cart.getInstance().getBooks();
        double total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }
        System.out.println("You have purchased items to the total value of: " + total);
        System.out.println("Thank you for shopping with The Reading Room!");
    }
    
}

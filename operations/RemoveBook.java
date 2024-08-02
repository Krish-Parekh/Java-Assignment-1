package Library.operations;

import Library.interfaces.Operation;
import Library.Cart;
import Library.Book;
import java.util.List;

public class RemoveBook implements Operation {

    @Override
    public void execute() {
        List<Book> books = Cart.getInstance().getBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the cart");
        } else {
            System.out.println("Your shopping cart contains the following book(s):");
            int bookNumber = 0;
            for (int i = 0; i < books.size(); i++) {
                ++bookNumber;
                System.out.println(bookNumber + ". " + books.get(i).getTitle());
            }
            if (bookNumber == 0) {
                System.out.println("No books in the cart");
                return;
            } else {
                System.out.println((bookNumber + 1) + ". Cancel");
            }

            System.out.print("Please select: ");
            int selectedBookNumber = Integer.parseInt(System.console().readLine());
            
            if(selectedBookNumber == bookNumber + 1) {
                return;
            }

            if (selectedBookNumber > 0 && selectedBookNumber <= books.size()) {
                Cart.getInstance().removeBook(books.get(selectedBookNumber - 1));
                System.out.println("The book has been removed from the cart");
            } else {
                System.out.println("Invalid book number");
            }
        }
    }

}

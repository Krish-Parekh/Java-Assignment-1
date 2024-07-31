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
            System.out.println("The following books are in the cart:");
            for (int i = 0; i < books.size(); i++) {
                int bookNumber = i + 1;
                System.out.println(bookNumber + ". " + books.get(i).getTitle());
            }
            System.out.println("Enter the number of the book to remove: ");
            int bookNumber = Integer.parseInt(System.console().readLine());
            if (bookNumber > 0 && bookNumber <= books.size()) {
                Cart.getInstance().removeBook(books.get(bookNumber - 1));
                System.out.println("The book has been removed from the cart");
            } else {
                System.out.println("Invalid book number");
            }
        }
    }

}

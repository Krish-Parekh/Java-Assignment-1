package Library.Operation;

import java.util.ArrayList;

import Library.Interface.Operation;
import Library.Model.Book;

public class ListAllBookOperation implements Operation {
    ArrayList<Book> allBooks;

    public ListAllBookOperation(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    @Override
    public void execute() {
        if(allBooks.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        System.out.println("The following books are available:");
        int counter = 1;
        for (Book book : allBooks) {
            System.out.println(counter + ". " + book.toString());
            counter++;
        }
    }

}

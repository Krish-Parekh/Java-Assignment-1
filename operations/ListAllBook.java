package Library.operations;

import Library.Book;
import java.util.ArrayList;
import Library.interfaces.Operation;

public class ListAllBook implements Operation {
    private ArrayList<Book> books;

    public ListAllBook(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public void execute() {
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            System.out.println("The following books are available:");
            for (int i = 0; i < books.size(); i++) {
                int bookNumber = i + 1;
                System.out.println(bookNumber + ". " + books.get(i).toString());
            }
        }
    }
}
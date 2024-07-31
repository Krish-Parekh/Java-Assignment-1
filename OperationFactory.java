package Library;

import java.util.ArrayList;
import java.util.List;

import Library.interfaces.Operation;

import Library.operations.AddBook;
import Library.operations.ViewCart;
import Library.operations.RemoveBook;
import Library.operations.ListAllBook;

public class OperationFactory {
    private List<Book> allBooks;

    public OperationFactory(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Operation createOperation(int choice) {
        switch (choice) {
            case 1: {
                Book book = selectBook();
                return new AddBook(book);
            }
            case 2: {
                return new ViewCart();
            }
            case 3: {
                return new RemoveBook();
            }
            case 4: {
                return null;
            }
            case 5: {
                return new ListAllBook(new ArrayList<>(allBooks));
            }
            default: {
                return null;
            }
        }
    }

    private Book selectBook() {
        Book selectedBook;
        System.out.println("Enter a keyword: ");
        String keyword = System.console().readLine();
        ArrayList<Book> searchedBooks = new ArrayList<>();
        System.out.println("The following book(s) are found: ");

        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (book.getTitle().contains(keyword)) {
                searchedBooks.add(book);
            }
        }

        int bookNumber = 0;
        for (int i = 0; i < searchedBooks.size(); i++) {
            ++bookNumber;
            System.out.println(bookNumber + ". " + searchedBooks.get(i).getTitle());
        }
        System.out.println((bookNumber + 1) + ". Cancel");

        int selectedBookNumber = Integer.parseInt(System.console().readLine());
        if (selectedBookNumber == bookNumber + 1) {
            return null;
        }
        selectedBook = searchedBooks.get(selectedBookNumber - 1);

        return selectedBook;
    }
}

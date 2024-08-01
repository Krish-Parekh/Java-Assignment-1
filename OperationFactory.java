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
        System.out.print("Enter a keyword: ");
        String keyword = System.console().readLine().toLowerCase();

        ArrayList<Book> searchedBooks = new ArrayList<>();
        System.out.println("The following book(s) are found: ");

        // Search for books that contain the keyword
        for (int i = 0; i < allBooks.size(); i++) {
            Book book = allBooks.get(i);
            if (book.getTitle().toLowerCase().contains(keyword)) {
                searchedBooks.add(book);
            }
        }

        // Display the search results
        int bookNumber = 0;
        for (int i = 0; i < searchedBooks.size(); i++) {
            ++bookNumber;
            System.out.println(bookNumber + ". " + searchedBooks.get(i).getTitle());
        }

        // Display the cancel option
        if (bookNumber == 0) {
            System.out.println("No book found.");
            return null;
        } else {
            System.out.println((bookNumber + 1) + ". Cancel");
        }

        // Select a book number to add to the cart
        System.out.print("Please select: ");
        int selectedBookNumber = Integer.parseInt(System.console().readLine());
        if (selectedBookNumber == bookNumber + 1) {
            return null;
        }

        // Ask the user, if they want to buy it as a EBook
        selectedBook = searchedBooks.get(selectedBookNumber - 1);

        System.out.print("Do you want to buy this as an ebook: ");
        String buyAsEBook = System.console().readLine();
        if (buyAsEBook.equals("yes")) {
            if (selectedBook.getHasEBook()) {
                System.out.println("EBook bought successfully");
            } else {
                System.out.println("EBook not available");
                return null;
            }
        } else {
            if (selectedBook.getNCopies() > 0) {
                selectedBook.setNCopies(selectedBook.getNCopies() - 1);
                System.out.println("Book bought successfully");
            } else {
                System.out.println("Book not available");
                return null;
            }
        }

        return selectedBook;
    }
}

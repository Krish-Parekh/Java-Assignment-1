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
                Book book = selectBook(allBooks);
                if (book == null) {
                    return null;
                }
                return new AddBook(book);
            }
            case 2: {
                return new ViewCart();
            }
            case 3: {
                List<Book> books = Cart.getInstance().getBooks();
                if (books.isEmpty()) {
                    System.out.println("Your shopping cart is empty");
                    return null;
                }
                Book book  = selectBook(Cart.getInstance().getBooks());
                if (book == null) {
                    return null;
                }
                return new RemoveBook(book);
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

    private Book selectBook(List<Book> books) {
        System.out.print("Enter a keyword: ");
        String keyword = System.console().readLine().toLowerCase();
        List<Book> searchedBooks = searchBooks(books, keyword);
        displaySearchResult(searchedBooks);
        int selectedBookNumber = selectBookNumber(searchedBooks.size());
        if (selectedBookNumber == -1) {
            return null;
        }
        return searchedBooks.get(selectedBookNumber - 1);
    }

    private List<Book> searchBooks(List<Book> books, String keyword) {
        List<Book> searchedBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getTitle().toLowerCase().contains(keyword)) {
                searchedBooks.add(book);
            }
        }
        return searchedBooks;
    }

    private void displaySearchResult(List<Book> searchedBooks) {
        if (searchedBooks.isEmpty()) {
            System.out.println("No books found");
            return;
        }
        int bookNumber = 0;
        System.out.println("Your shopping cart contains the following book(s): ");
        for (int i = 0; i < searchedBooks.size(); i++) {
            ++bookNumber;
            Book book = searchedBooks.get(i);
            System.out.println(bookNumber + ". " + book.getTitle());
        }
        if (bookNumber == 0) {
            System.out.println("No books found");
        } else {
            System.out.println((bookNumber + 1) + ". Cancel");
        }
    }

    private int selectBookNumber(int bookNumber) {
        System.out.print("Please select: ");
        int selectedBookNumber = Integer.parseInt(System.console().readLine());
        if (selectedBookNumber == bookNumber + 1) {
            System.out.println();
            return -1;
        }
        if (selectedBookNumber > 0 && selectedBookNumber <= bookNumber) {
            return selectedBookNumber;
        }
        System.out.println("Invalid option!");
        return -1;
    }
}

package Library.Operation;

import java.util.ArrayList;
import java.util.List;

import Library.Model.Book;
import Library.Model.CartBook;
import Library.Enums.BookType;
import Library.Interface.Operation;


/**
 * The OperationFactory class is responsible for creating different operations based on the user's choice.
 * It takes an ArrayList of books as a parameter and provides methods to create different operations such as adding a book, viewing a book, removing a book, checking out, and listing all books.
 */
public class OperationFactory {
    private ArrayList<Book> allBooks;

    public OperationFactory(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public Operation createOperation(int choice) {
        switch (choice) {
            case 1: {
                CartBook selectedBook = selectBook(allBooks);
                if (selectedBook == null) {
                    return null;
                }
                return new AddBookOperation(selectedBook);
            }
            case 2: {
                return new ViewBookOperation();
            }
            case 3: {
                return new RemoveBookOperation();
            }
            case 4: {
                return new CheckoutOperation();
            }
            case 5: {
                return new ListAllBookOperation(allBooks);
            }
            default: {
                return null;
            }
        }
    }

    private CartBook selectBook(List<Book> allBooks) {
        System.out.print("Enter a keyword: ");
        String keyword = System.console().readLine().toLowerCase();
        List<Book> searchedBooks = searchBooks(allBooks, keyword);
        if (searchedBooks.isEmpty()) {
            System.out.println("No books found\n");
            return null;
        }
        displaySearchResult(searchedBooks);
        int selectedBookNumber = selectBookNumber(searchedBooks.size());
        if (selectedBookNumber == -1) {
            return null;
        }
        Book selectedBook = searchedBooks.get(selectedBookNumber - 1);
        CartBook selectedCartBook = new CartBook(selectedBook);
        System.out.print("Do you want to buy this as an ebook: ");
        String buyAsEbook = System.console().readLine();
        if (buyAsEbook.equals("yes")) {
            if (selectedBook.getHasEBook()) {
                selectedCartBook.setBookType(BookType.EBOOK);
            } else {
                System.out.println("This book does not have an ebook available \n");
                return null;
            }
        } else {
            if (selectedBook.getNCopies() > 0) {
                selectedCartBook.setBookType(BookType.PHYSICAL);
                selectedBook.setNCopies(selectedBook.getNCopies() - 1);
            } else {
                System.out.println("This book is out of stock \n");
                return null;
            }
        }
        return selectedCartBook;

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
        int bookNumber = 0;
        System.out.println("Your shopping cart contains the following book(s): ");
        for (int i = 0; i < searchedBooks.size(); i++) {
            ++bookNumber;
            Book book = searchedBooks.get(i);
            String hasEBook = book.getHasEBook() ? "Yes" : "No";
            String nCopiesType = book.getNCopies() > 1 ? " copies" : " copy";
            System.out.println(bookNumber + ". " + book.getTitle() + " | " + book.getAuthors() + " | "
                    + book.getNCopies() + nCopiesType + " | " + hasEBook);
        }
        if (bookNumber == 0) {
            System.out.println("No books found \n");
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
        System.out.println("Invalid option! \n");
        return -1;
    }
}

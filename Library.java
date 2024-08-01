package Library;

import java.util.ArrayList;
import java.util.Scanner;

import Library.interfaces.Operation;

public class Library {

    static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Absolute Java", "Savitch", 5, true));
        books.add(new Book("JAVA: How to Program", "Deitel and Deitel", 0, true));
        books.add(new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false));
        books.add(new Book("Java Software Solutions", "Lewis and Loftus", 5, false));
        books.add(new Book("Java Program Design", "Cohoon and Davidson", 1, true));
        return books;
    }

    public static void main(String[] args) {
        ArrayList<Book> allBooks = loadBooks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=".repeat(30));
        System.out.println("Welcome to the Reading Room!");
        System.out.println("=".repeat(30));
        
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a book to shopping cart");
            System.out.println("2. View shopping cart");
            System.out.println("3. Remove a book from shopping cart");
            System.out.println("4. Checkout");
            System.out.println("5. List all books");
            System.out.println("6. Exit");
            System.out.print("Please select: ");

            int option = scanner.nextInt();

            if (option == 6) {
                break;
            }

            OperationFactory operationFactory = new OperationFactory(allBooks);
            Operation operation = operationFactory.createOperation(option);
            operation.execute();

            System.out.println();
        }

        scanner.close();
    }
}

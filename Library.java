package Library;

import java.util.ArrayList;
import java.util.Scanner;

import Library.Interface.Operation;
import Library.Model.Book;
import Library.Operation.OperationFactory;


/**
 * Name: Joe Doe
 * Student ID: s999999
 * 
 * Github: https://github.com/Krish-Parekh/Java-Assignment-1
 * 
 * Thought Process:
 * 1. This application uses design patterns to make the code more abstract and maintainable.
 * 
 * 2. The Factory Design Pattern is used to create objects for different operations that can be executed on 
 * the list of books. All operation classes implement the Operation interface, which defines the execute method.
 * 
 * 3. The Singleton Design Pattern is used to ensure that only a single instance of the Cart class is created 
 * in the JVM. This ensures that there is only one cart instance maintained for a single session.
 * 
 * Design Choice: 
 * 1. Preventing Multiple E-book Purchases:
 * - Reason: Users are not allowed to buy multiple copies of the same E-book because owning more than one digital copy is unnecessary.
 * 
 * VIDEO DEMO: https://rmiteduau-my.sharepoint.com/:v:/g/personal/s4043281_student_rmit_edu_au/Ee5fz7ON3A5OsBK2Q2xs8kEBix5j4Rtz2BFQjlyztcbYAQ?e=vVyMb5&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D
 */

public class Library {
    
    /**
     * Loads a list of books.
     *
     * @return An ArrayList of Book objects representing the loaded books.
     */
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

        System.out.println("=".repeat(50));
        System.out.println("Welcome to the Reading Room!");
        System.out.println("=".repeat(50));
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
            System.out.println();

            if (option == 6) {
                System.out.println("Goodbye!");
                break;
            }

            OperationFactory operationFactory = new OperationFactory(allBooks);
            Operation operation = operationFactory.createOperation(option);
            
            if (operation == null) {
                continue;
            }
            
            operation.execute();

            System.out.println();
        }

        scanner.close();
    }
}

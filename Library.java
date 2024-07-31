package Library;

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            
            System.out.println();
        }
        
        scanner.close();
    }
}

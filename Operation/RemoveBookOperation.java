package Library.Operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Library.Cart.Cart;
import Library.Enums.BookType;
import Library.Interface.Operation;
import Library.Model.CartBook;

public class RemoveBookOperation implements Operation {

    @Override
    public void execute() {
        LinkedHashMap<String, LinkedHashMap<BookType, ArrayList<CartBook>>> bookLookup = Cart.getInstance()
                .getBooksLookup();
        LinkedHashMap<Integer, CartBook> bookIndexLookup = new LinkedHashMap<>();
        
        if (bookLookup.isEmpty()) {
            System.out.println("Your shopping cart is empty");
            return;
        }

        System.out.println("Your shopping cart contains the following book(s):");
        int index = 1;
        for (String bookName : bookLookup.keySet()) {
            LinkedHashMap<BookType, ArrayList<CartBook>> bookTypeLookup = bookLookup.get(bookName);
            for (BookType bookType : bookTypeLookup.keySet()) {
                ArrayList<CartBook> cartBooks = bookTypeLookup.get(bookType);
                if (cartBooks.isEmpty()) {
                    continue;
                }
                String copyType = cartBooks.size() > 1 ? "copies" : "copy";
                System.out.println(index + ". " + bookName + " | " + cartBooks.size() + " " + copyType + " " + " | " + bookType);
                bookIndexLookup.put(index, cartBooks.get(0));
                index++;
            }
        }
        System.out.println(index + ". Cancel");
        System.out.print("Please select: ");
        int bookIndex = Integer.parseInt(System.console().readLine());

        if (bookIndex == index) {
            return;
        } else if (bookIndex < 1 || bookIndex > index) {
            System.out.println("Invalid selection");
            return;
        }

        Cart.getInstance().removeBook(bookIndexLookup.get(bookIndex));
    }
}

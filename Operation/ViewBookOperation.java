package Library.Operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Library.Cart.Cart;
import Library.Model.CartBook;
import Library.Enums.BookType;
import Library.Interface.Operation;

public class ViewBookOperation implements Operation {


    @Override
    public void execute() {
        LinkedHashMap<String, LinkedHashMap<BookType, ArrayList<CartBook>>> bookLookup = Cart.getInstance().getBooksLookup();
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
                String copyType = cartBooks.size() > 1 ? "copies" : "copy";
                System.out.println(index + ". " + bookName + " | " + cartBooks.size() + " " + copyType + " | " + bookType);
                index++;
            }
        }
    }

}

package Library.Operation;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import Library.Cart.Cart;
import Library.Enums.BookType;
import Library.Interface.Operation;
import Library.Model.CartBook;

public class CheckoutOperation implements Operation  {

    @Override
    public void execute() {
        LinkedHashMap<String, LinkedHashMap<BookType, ArrayList<CartBook>>> bookLookup = Cart.getInstance().getBooksLookup();
        if (bookLookup.isEmpty()) {
            System.out.println("No books in the cart\n");
            return;
        }
        double total = 0;
        for (String bookName : bookLookup.keySet()) {
            LinkedHashMap<BookType, ArrayList<CartBook>> bookTypeLookup = bookLookup.get(bookName);
            for (BookType bookType : bookTypeLookup.keySet()) {
                ArrayList<CartBook> cartBooks = bookTypeLookup.get(bookType);
                for (CartBook cartBook : cartBooks) {
                    total += cartBook.getBookPrice();
                }
            }
        }
        System.out.println("You have purchased items to the total value of: $" + total + " AUD");
        System.out.println("Thank you for shopping with The Reading Room!");
        Cart.getInstance().removeAllBooks();     
    }
    
}

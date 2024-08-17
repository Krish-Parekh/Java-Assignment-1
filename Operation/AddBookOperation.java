package Library.Operation;

import Library.Interface.Operation;
import Library.Cart.Cart;
import Library.Model.CartBook;

public class AddBookOperation implements Operation {

    private CartBook selectedBook;

    public AddBookOperation(CartBook selectedBook) {
        this.selectedBook = selectedBook;
    }

    @Override
    public void execute() {
        Cart.getInstance().addBook(selectedBook);
        System.out.println("\"" + selectedBook.getTitle() + "\"" + " has been added to your shopping cart");
    }

}

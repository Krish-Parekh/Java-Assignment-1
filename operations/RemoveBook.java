package Library.operations;

public class RemoveBook extends Operation {
    private Book book;

    public RemoveBook(Book book) {
        this.book = book;
    }

    @Override
    public void execute() {
        Cart.getInstance().removeBook(book);
    }
    
}

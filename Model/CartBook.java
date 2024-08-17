package Library.Model;

import Library.Enums.BookType;

public class CartBook extends Book {

    private BookType bookType;

    public CartBook(Book book) {
        super(book.getTitle(), book.getAuthors(), book.getNCopies(), book.getHasEBook());
        this.bookType = BookType.PHYSICAL;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public double getBookPrice() {
        return bookType.getPrice();
    }

}

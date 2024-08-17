package Library.Enums;

public enum BookType {
    PHYSICAL(50.0), EBOOK(8.0);

    private double price;

    BookType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}

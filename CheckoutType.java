package Library;

public enum CheckoutType {
    PHYSICAL(50.0), EBOOK(8.0);

    private double price;

    CheckoutType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}

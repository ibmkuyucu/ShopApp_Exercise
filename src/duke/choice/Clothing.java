package duke.choice;

public class Clothing implements Comparable<Clothing> {
    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }

    private String description;
    private String size = "M";
    private double price;
    public static final double MIN_PRICE = 10.0;
    public static final double TAX_RATE = 0.2;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return (1 + TAX_RATE) * price;
    }

    public void setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price : MIN_PRICE;
    }

    public String toString() {
        return description + ", " + price;
    }

    public int compareTo(Clothing c) {
        return description.compareTo(c.description);
    }
}

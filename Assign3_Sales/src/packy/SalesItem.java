package packy;

public class SalesItem {
    private String name;
    private double price;
    private int quantity;

    public SalesItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Calculate total cost for this item
    public double getTotalCost() {
        return price * quantity;
    }

    // toString method to display the item details
    public String toString() {
        return String.format("Item: %s, Price: %.2f, Quantity: %d, Total: %.2f", 
                              name, price, quantity, getTotalCost());
    }
}

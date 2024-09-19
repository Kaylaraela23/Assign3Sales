package packy;

import java.util.ArrayList;

public class SalesSlip {
    private ArrayList<SalesItem> items;

    public SalesSlip() {
        this.items = new ArrayList<>();
    }

    // Add a SalesItem to the list
    public void addItem(SalesItem item) {
        items.add(item);
    }

    // Calculate the total sales from all items
    public double getTotalSales() {
        double total = 0.0;
        for (SalesItem item : items) {
            total += item.getTotalCost();
        }
        return total;
    }

    // toString method to display the sales slip details
    public String toString() {
        StringBuilder slipDetails = new StringBuilder();
        for (SalesItem item : items) {
            slipDetails.append(item.toString()).append("\n");
        }
        slipDetails.append(String.format("Total Sales: %.2f", getTotalSales()));
        return slipDetails.toString();
    }
}

package packy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField itemNameField, itemPriceField, itemQuantityField;
    private JTextArea salesDisplay;
    private SalesSlip salesSlip;

    public Main() {
        salesSlip = new SalesSlip();
        setTitle("Sales List Application");
        setSize(500, 400); // Increased size for more space
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create an input panel for item details with GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5); // Spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Item Name Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Item Name:"), gbc);

        itemNameField = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(itemNameField, gbc);

        // Item Price Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Item Price:"), gbc);

        itemPriceField = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(itemPriceField, gbc);

        // Item Quantity Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Item Quantity:"), gbc);

        itemQuantityField = new JTextField(10);
        gbc.gridx = 1;
        inputPanel.add(itemQuantityField, gbc);

        // Add Item Button (with smaller size)
        JButton addButton = new JButton("Add Item");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE; // Allow button to be smaller
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(addButton, gbc);

        // Place the input panel in the center of the screen
        add(inputPanel, BorderLayout.CENTER);

        // Text area to display the sales items, placed at the bottom (larger output)
        salesDisplay = new JTextArea(10, 30); 
        salesDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(salesDisplay);
        add(scrollPane, BorderLayout.SOUTH);

        // Add ActionListener to the button with error handling for non-numeric inputs
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = itemNameField.getText();
                
                try {
                    double price = Double.parseDouble(itemPriceField.getText());
                    int quantity = Integer.parseInt(itemQuantityField.getText());

                    // Create new sales item and add to sales slip
                    SalesItem item = new SalesItem(name, price, quantity);
                    salesSlip.addItem(item);

                    // Update sales display area
                    salesDisplay.setText(salesSlip.toString());

                    // Clear input fields
                    itemNameField.setText("");
                    itemPriceField.setText("");
                    itemQuantityField.setText("");

                } catch (NumberFormatException ex) {
                    // Show error message dialog when price or quantity is not a valid number
                    JOptionPane.showMessageDialog(null,
                            "Please enter valid numeric values for Price and Quantity.",
                            "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }
}

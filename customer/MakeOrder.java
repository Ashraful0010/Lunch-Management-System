package customer;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MakeOrder extends JFrame {

    private JPanel panel;
    private JLabel labelMakeOrder;
    private JLabel labelSelectItem;
    private JLabel labelQuantity;
    private JComboBox dropdownItems;
    private JTextField tfQuantity;

    private JButton buttonConfirmOrder;

    public MakeOrder() {
        this.initializeComponents();

        this.setTitle("Order Section");
        this.setBounds(200, 150, 900, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//label make orders
        this.labelMakeOrder = new JLabel("Make Order");
        this.labelMakeOrder.setBounds(300, 10, 300, 50);
        // set font
        this.labelMakeOrder.setFont(new Font("Segoe UI Black", Font.BOLD, 40));

        this.panel.add(this.labelMakeOrder);

//label select items
        this.labelSelectItem = new JLabel("Select Item :");
        this.labelSelectItem.setBounds(30, 100, 300, 50);
        // set font
        this.labelSelectItem.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));

        this.panel.add(this.labelSelectItem);
//drop down box for items
        String items[] = new String[300];
        
        String file =".\\Data\\Menu.txt";
        
        // To input data in the Array
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
                totalLines++;
            reader.close();

            for (int i = 0; i < totalLines; i++) {
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("Item")) {
                    items[i] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // Item Name
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.dropdownItems = new JComboBox(items);
        this.dropdownItems.setBounds(300, 105, 280, 50);
        this.dropdownItems.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.dropdownItems);

//label Quantity
        this.labelQuantity = new JLabel("Quantity :");
        this.labelQuantity.setBounds(30, 175, 200, 50);
        // set font
        this.labelQuantity.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelQuantity);
// Text field for Quantity

        this.tfQuantity = new JTextField();
        this.tfQuantity.setBounds(300, 180, 280, 50);
        this.tfQuantity.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.tfQuantity);

// button Confirm Order
        this.buttonConfirmOrder = new JButton("Confirm Order");
        this.buttonConfirmOrder.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonConfirmOrder.setBounds(300, 280, 300, 50);
        this.buttonConfirmOrder.setBackground(Color.blue);
        this.buttonConfirmOrder.setForeground(Color.WHITE);
        this.panel.add(this.buttonConfirmOrder);
//  add ActionListener
        this.buttonConfirmOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String tf1 = tfQuantity.getText();

                if (tf1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the quantiy.");
                } else{
                    JOptionPane.showMessageDialog(null, "Your order has been confirmed.");
                    setVisible(false);
                    new Thanks();
                }
            }
        });

        this.add(this.panel);

    }

}

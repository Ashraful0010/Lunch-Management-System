package menu;

import customer.HaveAccount;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class MenuFrame extends JFrame {

    private JPanel panel;
    private JScrollPane scroll;
    private JTable table;
    private DefaultTableModel model;
    private JLabel labelMenu;
    private JButton buttonOrder;
    
    private String[] column = { "Item Name", "Price"};
    private String[] rows = new String[7];
    private JButton buttonBack;


    public MenuFrame() {
        this.initializeComponents();

        this.setTitle("Menu");
        this.setBounds(200,150,900,450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//  Menu label 
        this.labelMenu = new JLabel("MENU");
        this.labelMenu.setBounds(380, 10, 100, 30);
        this.labelMenu.setFont(new Font("Cascadia Mono Light", Font.BOLD, 30));
        this.labelMenu.setForeground(new Color(0, 0, 0));
        this.panel.add(this.labelMenu);
        
//  Table
        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(new Font("Segoe UI Black", Font.ITALIC, 15));
        table.setSelectionBackground(Color.CYAN);
        table.setBackground(Color.WHITE);
        table.setRowHeight(40);
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.setEnabled(false);

        scroll = new JScrollPane(table);
        scroll.setBounds(90, 60 ,700 , 250);
        scroll.setBackground(Color.WHITE);
        this.panel.add(scroll);

        String file = ".\\Data\\Menu.txt";

        // To input data in the table
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
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(8); // Password
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) {
            return;
        }
        

//  button Order
        this.buttonOrder = new JButton("Order Now");
        this.buttonOrder.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonOrder.setBounds(450, 340, 200, 40);
        this.buttonOrder.setBackground(Color.blue);
        this.buttonOrder.setForeground(Color.WHITE);
        this.panel.add(this.buttonOrder);
//  add ActionListener
        this.buttonOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String orderButton = event.getActionCommand();
                if (orderButton.equals("Order Now")) {
                    setVisible(false);
                    new HaveAccount();
                }
            }
        });
        
    // button - BACK
        this.buttonBack = new JButton("Back");
        this.buttonBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonBack.setBounds(220, 340, 200, 40);
        this.buttonBack.setBackground(Color.RED);
        this.buttonBack.setForeground(Color.WHITE);
        this.panel.add(this.buttonBack);

        this.buttonBack.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String buttonBack = event.getActionCommand();
                    if(buttonBack.equals("Back"))
                    {
                        setVisible(false);
                        new Welcome();
                    }
                }
            });

        this.add(this.panel);
    }
}

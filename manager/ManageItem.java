package manager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import menu.Welcome;

public class ManageItem extends JFrame {

    private JPanel panel;
    private JTextField textName;
    private JTextField textPrice;
    private JButton buttonLogout;
    private JButton buttonAdd;

    private JLabel labelName;
    private JLabel labelAdditem;
    private JLabel labelprice;

    public ManageItem() {
        this.initializeComponents();

        this.setTitle("Manage Item");
        this.setBounds(200, 150, 900, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//Label - Add Item
        this.labelAdditem = new JLabel("Add Item");
        this.labelAdditem.setBounds(400, 10, 200, 50);
        // set font
        this.labelAdditem.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
       
        this.panel.add(this.labelAdditem);

        //Label - Name
        this.labelName = new JLabel("Item Name :");
        this.labelName.setBounds(30, 100, 200, 50);
        // set font
        this.labelName.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelName);

        //TextField- Name
        this.textName = new JTextField();
        this.textName.setBounds(300, 105, 250, 50);
        this.textName.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.textName);

        //Label - Price
        this.labelprice = new JLabel("Price  :");
        this.labelprice.setBounds(30, 200, 150, 50);
        // set font
        this.labelprice.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelprice);

        //TextField- Price
        this.textPrice = new JTextField();
        
        this.textPrice.setBounds(300, 200, 250, 50);
        this.textPrice.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.textPrice);


//      Add Button
        this.buttonAdd = new JButton("Add");
        this.buttonAdd.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonAdd.setBounds(210, 300, 200, 50);
        this.buttonAdd.setBackground(Color.blue);
        this.buttonAdd.setForeground(Color.WHITE);
        this.panel.add(this.buttonAdd);

        this.buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = textName.getText();
                String tf2 = textPrice.getText();

                if (tf1.isEmpty() || tf2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.");
                } else {
                    try {
                        File file = new File(".\\Data\\Menu.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        pw.println("Item Name : " + tf1);
                        pw.println("Price : " + tf2);
                        pw.println("===============================================");
                        pw.close();
                    } catch (Exception ex) {
                        System.out.print(ex);
                        
                    }
                    
                    JOptionPane.showMessageDialog(null, "Item has been added.");
                    setVisible(false);
                    new ManageItem();
                }
            }

        });

//      Logout Button
        this.buttonLogout = new JButton("Log Out");
        this.buttonLogout.setBounds(450,300,200,50);
        this.buttonLogout.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonLogout.setBackground(Color.blue);
        this.buttonLogout.setForeground(Color.WHITE);
        this.panel.add(this.buttonLogout);

        this.buttonLogout.addActionListener((ActionEvent event) -> {
            String buttonLogout = event.getActionCommand();
            if (buttonLogout.equals("Log Out")) {
                setVisible(false);
                new Welcome();
            }
        });

        this.add(this.panel);
    }
}

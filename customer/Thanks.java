package customer;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class Thanks extends JFrame
{
    private JPanel panel;
    private JLabel thanks;

    public Thanks()
    {
        this.initializeComponents();

        this.setTitle("Thank You");
        this.setBounds(200, 150, 900, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
   
    private void initializeComponents()
    {
        this.panel = new JPanel (null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//  label Thank You

        this.thanks = new JLabel ("Thank You");
        this.thanks.setBounds(200, 150, 500, 70);
        // set font
        this.thanks.setFont(new Font("Segoe UI Black", Font.BOLD, 80));
       
        this.panel.add(this.thanks);

        this.add(this.panel);

    }
}
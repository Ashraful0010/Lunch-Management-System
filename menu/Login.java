
package menu;

import customer.MakeOrder;
import menu.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

public class Login extends JFrame {

    private JPanel panel;
    private JLabel labellogin;
    private JLabel labelUserName;
    private JTextField textUserName;
    private JLabel labelPassword;
    private JPasswordField password;
    private JButton buttonlogin;
    private JButton buttonBack;

    public Login() {
        this.initializeComponents();

        this.setTitle("Log In");
        this.setBounds(200, 150, 900, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

        // label - Login
        this.labellogin = new JLabel("Log In");
        this.labellogin.setBounds(300, 10, 200, 60);
        // set font
        this.labellogin.setFont(new Font("Segoe UI Black", Font.BOLD, 50));

        this.panel.add(this.labellogin);

        // label - Username
        this.labelUserName = new JLabel("Username : ");
         //Set Font
       this.labelUserName.setBounds(80, 100, 300, 50);
        // set font
        this.labelUserName.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelUserName);
        
        //TextField- Username
        this.textUserName = new JTextField();
         this.textUserName.setBounds(300, 105, 250, 50);
        this.textUserName.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.textUserName);
        //label - password
        this.labelPassword = new JLabel("Password  : ");
       this.labelPassword.setBounds(80, 200, 300, 50);
        this.labelPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelPassword);;

        // Passwordfield - Password
        this.password = new JPasswordField();
        this.password.setBounds(300, 205, 250, 50);
        this.password.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.password);

        // button - login
        this.buttonlogin = new JButton("Log in");
       this.buttonlogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonlogin.setBounds(450, 305, 150, 50);
        this.buttonlogin.setBackground(Color.blue);
        this.buttonlogin.setForeground(Color.WHITE);
        this.panel.add(this.buttonlogin);
    
    //  Back Button
        this.buttonBack = new JButton("Back");
        this.buttonBack.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonBack.setBounds(200, 305, 150, 50);
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

        this.buttonlogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = textUserName.getText();
                String tf2 = password.getText();

                if (tf1.isEmpty() || tf2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill all of the fields");
                } else {
                    try {
                        String username = "Username : " + tf1;
                        String pass = "Password : " + tf2;
                        BufferedReader reader = new BufferedReader(new FileReader(".\\Data\\User_Data.txt"));

                        int totalLines = 0;
                        while (reader.readLine() != null) {
                            totalLines++;
                        }
                        reader.close();

                        for (int i = 0; i <= totalLines; i++) {
                            String line1 = Files.readAllLines(Paths.get(".\\Data\\User_Data.txt")).get(i);
                            if (line1.equals(username)) {
                                String line2 = Files.readAllLines(Paths.get(".\\Data\\User_Data.txt")).get((i + 1));
                                if (line2.equals(pass)) {
                                    JOptionPane.showMessageDialog(null, "Login Successful.");
                                    setVisible(false);
                                    new MakeOrder();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                                }
                            }
                        }
                    } catch (Exception ex) {
                        System.out.print(ex);
                    }
                }
            }

        });

        this.add(this.panel);
    }
}

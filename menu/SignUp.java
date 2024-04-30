package menu;

import customer.MakeOrder;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SignUp extends JFrame {

    private JPanel panel;
    private JLabel labelSignUp;
    private JLabel labelUserName;
    private JLabel labelPassword;

    private JTextField tfUserName;
    private JPasswordField pfPassword;

    private JButton ButtonEnter;
    private JButton buttonBack;

    public SignUp() {
        this.initializeComponents();

        this.setTitle("Sign Up");
        this.setBounds(200, 150, 900, 450);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeComponents() {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//Label sign up
        this.labelSignUp = new JLabel("SIGN UP");
        this.labelSignUp.setBounds(300, 10, 300, 50);
        // set font
        this.labelSignUp.setFont(new Font("Segoe UI Black", Font.BOLD, 50));

       
        this.panel.add(this.labelSignUp);

//label Enter User Name
        this.labelUserName = new JLabel("Set Username :");
        this.labelUserName.setBounds(30, 100, 300, 50);
        // set font
        this.labelUserName.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelUserName);

        this.tfUserName = new JTextField();
        this.tfUserName.setBounds(300, 105, 250, 50);
        this.tfUserName.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.tfUserName);
//label for password
        this.labelPassword = new JLabel("Set Password :");
        this.labelPassword.setBounds(30, 200, 300, 50);
        this.labelPassword.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelPassword);

        // textfield Password
        this.pfPassword = new JPasswordField();
        this.pfPassword.setBounds(300, 205, 250, 50);
        this.pfPassword.setFont(new Font("Segoe UI Black ", Font.PLAIN, 30));
        this.panel.add(this.pfPassword);

    //  button - BACK
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

// button Enter
        this.ButtonEnter = new JButton("Enter");
        this.ButtonEnter.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.ButtonEnter.setBounds(450, 305, 150, 50);
        this.ButtonEnter.setBackground(Color.blue);
        this.ButtonEnter.setForeground(Color.WHITE);
        this.panel.add(this.ButtonEnter);

        this.ButtonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tf1 = tfUserName.getText();
                String tf2 = pfPassword.getText();

                int result = 0;

                if (tf1.isEmpty() || tf2.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all of the fields.");
                } else {
                    try {
                        File file = new File(".\\Data\\User_Data.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        pw.println("Username : " + tf1);
                        pw.println("Password : " + tf2);
                        pw.println("===============================================");
                        pw.close();

                    } catch (Exception ex) {
                        System.out.print(ex);
                    }

                    JOptionPane.showMessageDialog(null, "Sign up completed successfully.");
                    setVisible(false);
                    new MakeOrder();
                }

            }

        });

        this.add(this.panel);
    }
}

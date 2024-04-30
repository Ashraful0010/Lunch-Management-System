package menu;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Welcome extends JFrame

{
    private JPanel panel;
    private JLabel labelWelcome;
    private JLabel labelTo;
    private JLabel label_Name;
    private JButton buttonMenu;
    private JButton buttonLogin;
    private JButton buttonSignUp;
    private JButton buttonManagerLogin;

    public Welcome()
    {
       this.initializeComponents();

       this.setTitle(null);
       this.setBounds(200,150,900,450);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true); 
    }

    public void initializeComponents()
    
    {
        this.panel = new JPanel(null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

    //   1st line
        this.labelWelcome = new JLabel("Welcome");
        this.labelWelcome.setBounds(320,10,300,50);
        this.labelWelcome.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
        this.panel.add(this.labelWelcome);
        
    //   2nd line
        this.labelTo = new JLabel("To");
        this.labelTo.setBounds(430,50,200,50);
        this.labelTo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.panel.add(this.labelTo);
        
    //   3rd line
        this.label_Name = new JLabel("2");
        this.label_Name.setBounds(370,50,200,100);
    //  this.label_Name.setForeground(Color.RED);
        this.label_Name.setFont(new Font("Segoe UI Black", Font.ITALIC, 90));
        this.panel.add(this.label_Name);
    
    //   4th line
        this.label_Name = new JLabel("pm");
        this.label_Name.setBounds(420,75,200,100);
        this.label_Name.setFont(new Font("Segoe UI Black", Font.ITALIC, 30));
        this.panel.add(this.label_Name);

//   Menu Button
        this.buttonMenu = new JButton("Menu");
        this.buttonMenu.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonMenu.setBounds(120, 230, 180, 40);
        this.buttonMenu.setBackground(Color.blue);
        this.buttonMenu.setForeground(Color.WHITE);
        this.panel.add(this.buttonMenu);

//  adding actionListener
            this.buttonMenu.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String menuButton = event.getActionCommand();
                    if(menuButton.equals("Menu"))
                    {
                        setVisible(false);
                        new MenuFrame();
                    }
                }
            });


        
//   LogIn Button
        this.buttonLogin = new JButton("Log In");
        this.buttonLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonLogin.setBounds(350, 230, 180, 40);
        this.buttonLogin.setBackground(Color.blue);
        this.buttonLogin.setForeground(Color.WHITE);
        this.panel.add(this.buttonLogin);

    //    adding actionListener
            this.buttonLogin.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String loginButton = event.getActionCommand();
                    if(loginButton.equals("Log In"))
                    {
                        setVisible(false);
                        new Login();
                    }
                }
            });
        
//   SignUp Button
        this.buttonSignUp = new JButton("Sign Up");
        this.buttonSignUp.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonSignUp.setBounds(570, 230, 180, 40);
        this.buttonSignUp.setBackground(Color.blue);
        this.buttonSignUp.setForeground(Color.WHITE);
        this.panel.add(this.buttonSignUp);

    //    adding actionListener
            this.buttonSignUp.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String signupButton = event.getActionCommand();
                    if(signupButton.equals("Sign Up"))
                    {
                        setVisible(false);
                        new SignUp();
                    }
                }
            });
            
//   Manager LogIn Button
        this.buttonManagerLogin = new JButton("Manager Log In");
        this.buttonManagerLogin.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        this.buttonManagerLogin.setBounds(315, 300, 245, 40);
        this.buttonManagerLogin.setBackground(Color.blue);
        this.buttonManagerLogin.setForeground(Color.WHITE);
        this.panel.add(this.buttonManagerLogin);

    //    adding actionListener
            this.buttonManagerLogin.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent event)
                {
                    String MloginButton = event.getActionCommand();
                    if(MloginButton.equals("Manager Log In"))
                    {
                        setVisible(false);
                        new ManagerLogin();
                    }
                }
            });
        
            
            
        
        this.add(this.panel);
    
    }
}
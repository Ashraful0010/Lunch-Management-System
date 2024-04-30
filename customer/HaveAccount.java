package customer;
import menu.Login;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import menu.SignUp;

public class HaveAccount extends JFrame 
{
    private JPanel panel;
    private JLabel labelQuestion;

    
    private JButton buttonYes;
    private JButton buttonNo;




    public HaveAccount()
    {
        this.initializeComponents();

        this.setTitle("Info");
        this.setBounds(300, 200, 700, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    private void initializeComponents()
    {
        this.panel = new JPanel (null);
        this.panel.setBackground(Color.decode("#CDFFFF"));

//label for Question (Do you have an accounnt?)

        this.labelQuestion = new JLabel ("Do you have an account? ");
        this.labelQuestion.setBounds(130,40,600,50);
// set font
        this.labelQuestion.setFont(new Font("Segoe UI Black", Font.BOLD, 30));        
        this.panel.add(this.labelQuestion);

       
// Button Yes

        this.buttonYes = new JButton ("Yes");
        this.buttonYes.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonYes.setBounds(120, 180, 200, 50);
        this.buttonYes.setBackground(Color.blue);
        this.buttonYes.setForeground(Color.WHITE);
        this.panel.add(this.buttonYes);

       this.buttonYes.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
          String buttonText= event.getActionCommand();
          if (buttonText.equals("Yes")) {
            setVisible(false);  
            new Login();
          }
        }

      });

// Button No

        this.buttonNo = new JButton ("No");
        this.buttonNo.setBounds(350,180,200,50);
        this.buttonNo.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
        this.buttonNo.setBackground(Color.blue);
        this.buttonNo.setForeground(Color.WHITE);
        this.panel.add(this.buttonNo);

        this.buttonNo.addActionListener(new ActionListener()
      {
        public void actionPerformed(ActionEvent event)
        {
          String buttonText= event.getActionCommand();
          if (buttonText.equals("No")) {
            setVisible(false);
            new SignUp();
          }
        }

      });

        this.add(this.panel);

    }

}
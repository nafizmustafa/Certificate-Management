import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPage extends JFrame {
    FirstPage(){
        JLabel text = new JLabel("Welcome To Certificate Management System");
        JLabel text2 = new JLabel("Choose the correct one!");
        JButton admin = new JButton("Admin");
        JButton user = new JButton("User");

        text.setBounds(75,80,270,25);
        text2.setBounds(140,110,250,30);


        admin.setBounds(80,200,100,25);
      admin.addActionListener(new ActionListener() {

          public void actionPerformed(ActionEvent e) {
              setVisible(false);
              AdminLogIn adminObj = new AdminLogIn();
              adminObj.setVisible(true);

          }
      });
        user.setBounds(225,200,100,25);
        user.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LogInForm logInObj = new LogInForm();
                logInObj.setVisible(true);

            }
        });


        this.add(text);
        this.add(text2);
        this.add(admin);
        this.add(user);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);


    }
}

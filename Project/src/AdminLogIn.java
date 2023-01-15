import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogIn extends JFrame {

   AdminLogIn(){
       JButton backButton = new JButton("Back");
       JButton logInAdmin = new JButton("Log In");

       JTextField userId = new JTextField();
       JPasswordField password = new JPasswordField();
       JLabel userIdLabel = new JLabel("User ID");
       JLabel passwordLabel = new JLabel("Password");

       userIdLabel.setBounds(50,100,75,25);
       passwordLabel.setBounds(50,150,75,25);

       userId.setBounds(125,100,200,25);
       password.setBounds(125,150,200,25);

       backButton.setBounds(125,200,100,25);
       backButton.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent e) {
               setVisible(false);
               FirstPage firstPage = new FirstPage();
               firstPage.setVisible(true);

           }
       });
       logInAdmin.setBounds(225,200,100,25);
       logInAdmin.addActionListener(new ActionListener() {

           public void actionPerformed(ActionEvent e) {
               if (userId.getText().toString().equals("admin") && password.getText().toString().equals("12345")){
                    dispose();
                   AdminControl adminControl = new AdminControl();
                   adminControl.setVisible(true);
               }else {
                   JOptionPane.showMessageDialog(null, " Wrong Password or User ID !");
               }


           }
       });



       this.add(userIdLabel);
       this.add(passwordLabel);
       this.add(userId);
       this.add(password);
       this.add(backButton);
       this.add(logInAdmin);

       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setTitle("Certificate Management System");
       this.setSize(420,420);
       this.setLayout(null);
       this.setVisible(true);


   }

}

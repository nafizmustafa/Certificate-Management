import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LogInForm extends JFrame {
    LogInForm(){
        //JFrame frame = new JFrame("Certificate Management System");
        JButton logInButton = new JButton("Log In");
        JButton RegisterButton = new JButton("Sign Up");
        JButton backButton = new JButton("Back");

        JTextField userId = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel userIdLabel = new JLabel("User ID");
        JLabel passwordLabel = new JLabel("Password");

        userIdLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        userId.setBounds(125,100,200,25);
        password.setBounds(125,150,200,25);

        logInButton.setBounds(125,200,100,25);
        logInButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean matched= false;
                String uname = userId.getText().toString();
               String pass = password.getText().toString();


                try {
                    FileReader fileReader = new FileReader("Users_Log.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line ;
                    while ((line=bufferedReader.readLine())!=null){
                        if (line.equals(uname+"\t"+pass)){
                            matched=true;
                            break;
                        }
                    }
                    fileReader.close();
                } catch (Exception ex) {
                    //throw new RuntimeException(ex);
                }
                if (matched){
                    dispose();
                   UserControl userControl= new UserControl();
                   userControl.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Wrong!");
                }

            }
        });


        RegisterButton.setBounds(225,200,100,25);
        RegisterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               RegisterForm registerForm= new RegisterForm();
               registerForm.setVisible(true);
            }
        });
        backButton.setBounds(125,250,200,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstPage firstPage = new FirstPage();
                firstPage.setVisible(true);

            }
        });

        this.add(userIdLabel);
        this.add(passwordLabel);
        this.add(userId);
        this.add(password);
        this.add(logInButton);
        this.add(RegisterButton);
        this.add(backButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);



    }


}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class RegisterForm extends JFrame {
    RegisterForm(){

        JButton register = new JButton("Register");
        JButton backButton = new JButton("Back");

        JTextField userId = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel userIdLabel = new JLabel("User ID");
        JLabel passwordLabel = new JLabel("Password");

        userIdLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        userId.setBounds(125,100,200,25);
        password.setBounds(125,150,200,25);



        register.setBounds(125,200,200,25);
        register.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter("Users_Log.txt",true);
                    fileWriter.write(userId.getText()+"\t"+password.getText()+"\n");
                    fileWriter.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Registration Completed");
                    //dispose();
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Not Added");
                }


            }
        });
        backButton.setBounds(125,250,200,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LogInForm logInForm = new LogInForm();
                logInForm.setVisible(true);

            }
        });

        this.add(userIdLabel);
        this.add(passwordLabel);
        this.add(userId);
        this.add(password);
        this.add(register);
        this.add(backButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);



    }


}

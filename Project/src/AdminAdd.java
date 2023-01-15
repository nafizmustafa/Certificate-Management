import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AdminAdd extends JFrame {
    AdminAdd(){

        JButton add_user = new JButton("Add User");
        JButton backButton = new JButton("Back");

        JTextField userId = new JTextField();
        JPasswordField password = new JPasswordField();
        JLabel userIdLabel = new JLabel("User ID");
        JLabel passwordLabel = new JLabel("Password");

        userIdLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        userId.setBounds(125,100,200,25);
        password.setBounds(125,150,200,25);



        add_user.setBounds(125,200,200,25);
        add_user.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter fileWriter = new FileWriter("Users_Log.txt",true);
                    fileWriter.write(userId.getText()+"\t"+password.getText()+"\n");
                    fileWriter.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f,"Successfully Added The User!");
                    //dispose();
                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Failed To Add The User!");
                }


            }
        });
        backButton.setBounds(125,250,200,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminControl adminControl = new AdminControl();
                adminControl.setVisible(true);

            }
        });

        this.add(userIdLabel);
        this.add(passwordLabel);
        this.add(userId);
        this.add(password);
        this.add(add_user);
        this.add(backButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);



    }


}

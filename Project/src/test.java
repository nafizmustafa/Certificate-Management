import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame {
    test(){
        JLabel text = new JLabel("Welcome To Certificate Management System");
        JLabel text2 = new JLabel("Choose the correct one!");


        text.setBounds(75,80,270,25);
        text2.setBounds(140,110,250,30);



        this.add(text);
        this.add(text2);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);


    }
}

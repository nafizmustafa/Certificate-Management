import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Blood extends JFrame {

    Blood() throws IOException {
        JLabel text = new JLabel("Please,Submit Your Details");
        text.setBounds(130,40,270,25);

        JLabel nameLabel = new JLabel("Full Name");
        JTextField fullName = new JTextField();
        nameLabel.setBounds(50,100,75,25);
        fullName.setBounds(125,100,200,25);

        JLabel ageLabel = new JLabel("Age");
        JTextField age = new JTextField();
        ageLabel.setBounds(50,150,75,25);
        age.setBounds(125,150,200,25);

        JLabel bloodLabel = new JLabel("Blood Group");
        JTextField blood = new JTextField();
        bloodLabel.setBounds(50,200,75,25);
        blood.setBounds(125,200,200,25);


        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");
        JButton logOut = new JButton("Log Out");
        backButton.setBounds(125,300,100,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                UserControl userControl = new UserControl();
                userControl.setVisible(true);

            }
        });

        submitButton.setBounds(225,300,100,25);
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String fullNameText = fullName.getText();
                String ageText = age.getText();
                String bloodText = blood.getText();





                // File creation
                File file = new File("Blood.txt");



                // FileWriter use
                try {
                    FileWriter myWriter = new FileWriter("Blood.txt",true);
                    myWriter.write(fullNameText+"\t"+ageText+"\t"+bloodText+"\n");

                    JOptionPane.showMessageDialog(null, "Successfully Submitted !");

                    myWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE,null,ex);
                }



            }


        });
        logOut.setBounds(125,300,200,25);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstPage firstPage = new FirstPage();
                firstPage.setVisible(true);
            }
        });



        // Everything Add to the java form

        this.add(nameLabel);
        this.add(fullName);
        this.add(ageLabel);
        this.add(age);
        this.add(bloodLabel);
        this.add(blood);
        this.add(backButton);
        this.add(submitButton);
        this.add(text);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);

    }

}

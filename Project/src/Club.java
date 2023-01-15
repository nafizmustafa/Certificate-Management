import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Club extends JFrame {

    Club() throws IOException {
        JLabel text = new JLabel("Please,Submit Your Details");
        text.setBounds(130,40,270,25);

        JLabel nameLabel = new JLabel("Full Name");
        JTextField fullName = new JTextField();
        nameLabel.setBounds(50,100,75,25);
        fullName.setBounds(125,100,200,25);

        JLabel clubLabel = new JLabel("Club Name");
        JTextField club = new JTextField();
        clubLabel.setBounds(50,150,75,25);
        club.setBounds(125,150,200,25);

        JLabel positionLabel = new JLabel("Position");
        JTextField position = new JTextField();
        positionLabel.setBounds(50,200,75,25);
        position.setBounds(125,200,200,25);

        JLabel workLabel = new JLabel("Work Year");
        JTextField work = new JTextField();
        workLabel.setBounds(30,250,75,25);
        work.setBounds(125,250,200,25);



        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");
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
                String clubText = club.getText();
                String positionText = position.getText();
                String workText = work.getText();





                // File creation
                File file = new File("Club.txt");



                // FileWriter use
                try {
                    FileWriter myWriter = new FileWriter("Club.txt",true);
                    myWriter.write(fullNameText+"\t"+clubText+"\t"+positionText+"\t"+workText+"\n");


                    JOptionPane.showMessageDialog(null, "Successfully Submitted !");

                    myWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE,null,ex);
                }



            }


        });


        // Everything Add to the java form

        this.add(nameLabel);
        this.add(fullName);
        this.add(clubLabel);
        this.add(club);
        this.add(positionLabel);
        this.add(position);
        this.add(workLabel);
        this.add(work);
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

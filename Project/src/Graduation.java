import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Graduation extends JFrame {

    Graduation() throws IOException {
        JLabel text = new JLabel("Please,Submit Your Details");
        text.setBounds(130,30,270,25);

        JLabel nameLabel = new JLabel("Full Name");
        JTextField fullName = new JTextField();
        nameLabel.setBounds(50,70,75,25);
        fullName.setBounds(125,70,200,25);

        JLabel varsityLabel = new JLabel("Varsity");
        JTextField varsity = new JTextField();
        varsityLabel.setBounds(50,100,75,25);
        varsity.setBounds(125,100,200,25);

        JLabel departmentLabel = new JLabel("Department");
        JTextField department = new JTextField();
        departmentLabel.setBounds(50,130,75,25);
        department.setBounds(125,130,200,25);

        JLabel creditsLabel = new JLabel("Credits");
        JTextField credit = new JTextField();
        creditsLabel.setBounds(50,160,75,25);
        credit.setBounds(125,160,200,25);

        JLabel cgpaLabel = new JLabel("CGPA");
        JTextField cgpa = new JTextField();
        cgpaLabel.setBounds(50,190,75,25);
        cgpa.setBounds(125,190,200,25);

        JLabel idLabel = new JLabel("ID");
        JTextField id = new JTextField();
        idLabel.setBounds(50,220,75,25);
        id.setBounds(125,220,200,25);



        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");
        backButton.setBounds(125,280,100,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                UserControl userControl = new UserControl();
                userControl.setVisible(true);
            }
        });

        submitButton.setBounds(225,280,100,25);
        submitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String fullNameText = fullName.getText();
                String varsityText = varsity.getText();
                String departmentText = department.getText();
                String creditText = credit.getText();
                String cgpaText = cgpa.getText();
                String idText = id.getText();





                // File creation
                File file = new File("Graduate.txt");



                // FileWriter use
                try {
                    FileWriter myWriter = new FileWriter("Graduate.txt",true);

                    myWriter.write(fullNameText+"\t"+varsityText+"\t"+departmentText+"\t"+creditText+"\t"+cgpaText+"\t"+idText+"\n");

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
        this.add(varsityLabel);
        this.add(varsity);
        this.add(departmentLabel);
        this.add(department);
        this.add(creditsLabel);
        this.add(credit);
        this.add(cgpaLabel);
        this.add(cgpa);
        this.add(idLabel);
        this.add(id);
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

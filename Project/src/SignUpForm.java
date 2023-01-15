import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpForm extends JFrame {

    SignUpForm() throws IOException {
        JLabel nameLabel = new JLabel("Full Name");
        JTextField fullName = new JTextField();
        nameLabel.setBounds(50,40,75,25);
        fullName.setBounds(125,40,200,25);

        JLabel departmentLabel = new JLabel("Department");
        JTextField department = new JTextField();
        departmentLabel.setBounds(50,70,75,25);
        department.setBounds(125,70,200,25);

        JLabel fatherLabel = new JLabel("Father Name");
        JTextField fatherName = new JTextField();
        fatherLabel.setBounds(50,100,75,25);
        fatherName.setBounds(125,100,200,25);

        JLabel mailLabel = new JLabel("Email");
        JTextField mail = new JTextField();
        mailLabel.setBounds(50,130,75,25);
        mail.setBounds(125,130,200,25);

        JLabel cityLabel = new JLabel("City");
        JTextField city = new JTextField();
        cityLabel.setBounds(50,160,75,25);
        city.setBounds(125,160,200,25);

        JLabel idLabel = new JLabel("User ID");
        JTextField id = new JTextField();
        idLabel.setBounds(50,190,75,25);
        id.setBounds(125,190,200,25);

        JLabel passLabel = new JLabel("Password");
        JPasswordField pass = new JPasswordField();
        passLabel.setBounds(50,220,75,25);
        pass.setBounds(125,220,200,25);

        JButton backButton = new JButton("Back");
        JButton resisterButton = new JButton("Resister");
        backButton.setBounds(125,250,100,25);
        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LogInForm logInForm = new LogInForm();
                logInForm.setVisible(true);

            }
        });

        resisterButton.setBounds(225,250,100,25);
        resisterButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               String fullNameText = fullName.getText();
               String departmentText = department.getText();
               String fatherNameText = fatherName.getText();
               String mailText = mail.getText();
               String cityText = city.getText();
               String idText = id.getText();
               String password = String.valueOf(pass.getPassword());




               // File creation
                File file = new File("users.txt");



            // FileWriter use
          try {
                FileWriter myWriter = new FileWriter("users.txt");

                myWriter.write("Full Name: "+fullNameText);
                myWriter.write(System.getProperty("line.separator"));
              myWriter.write("Department Name: "+departmentText);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("Father Name: "+fatherNameText);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("Email: "+mailText);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("City: "+cityText);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("ID: "+idText);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("Password: "+password);
              myWriter.write(System.getProperty("line.separator"));
              myWriter.write("-----------");

              JOptionPane.showMessageDialog(null, "Successfully Added !");

                myWriter.close();
            } catch (IOException ex) {
              Logger.getLogger(SignUpForm.class.getName()).log(Level.SEVERE,null,ex);
            }



            }


        });


        // Everything Add to the java form

        this.add(nameLabel);
        this.add(fullName);
        this.add(departmentLabel);
        this.add(department);
        this.add(fatherLabel);
        this.add(fatherName);
        this.add(mailLabel);
        this.add(mail);
        this.add(cityLabel);
        this.add(city);
        this.add(idLabel);
        this.add(id);
        this.add(passLabel);
        this.add(pass);
        this.add(backButton);
        this.add(resisterButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);

    }

}

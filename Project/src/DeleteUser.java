
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class DeleteUser {

    //declare global variables
    JFrame frame;
    JPanel panel;
    JLabel userLabel;
    JTextField userText;
    JButton deleteButton;

    public DeleteUser() {
        //create the frame
        frame = new JFrame("Delete User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create the panel
        panel = new JPanel();

        //create the label
        userLabel = new JLabel("Enter user name to delete: ");

        //create the text field
        userText = new JTextField(15);

        //create the button
        deleteButton = new JButton("Delete");

        //add action listener to the button
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get the user name
                String userName = userText.getText();

                //call the deleteUser method
                deleteUser(userName);

                //display message
                JOptionPane.showMessageDialog(null, "User "+userName+" deleted from file");
            }
        });

        //add components to the panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(deleteButton);

        //add the panel to the frame
        frame.add(panel);

        //set the size of the frame
        frame.setSize(300, 300);

        //make the frame visible
        frame.setVisible(true);
    }

    public void deleteUser(String userName) {
        try {
            //open the file
            File file = new File("Users_Log.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //create a new temp file
            File tempFile = new File("temp.txt");

            //create a new buffered writer
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            //read the file line by line
            String line;
            while ((line = reader.readLine()) != null) {
                //if the line is not the user name, write the line to the temp file
                if (!line.equals(userName+"\t")) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            //close the reader and writer
            writer.close();
            reader.close();

            //delete the original file
            file.delete();

            //rename the temp file
            tempFile.renameTo(file);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
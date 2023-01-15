import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class AdminDelete extends JFrame {
    AdminDelete(){

        JButton delete_user = new JButton("Delete User");
        JButton backButton = new JButton("Back");

        JTextField userId = new JTextField();
        JLabel userIdLabel = new JLabel("User ID");

        userIdLabel.setBounds(50,100,75,25);

        userId.setBounds(125,100,200,25);



        delete_user.setBounds(125,200,200,25);
        delete_user.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean matched= false;
                String uname = userId.getText().toString();

                try {
                    FileReader fileReader = new FileReader("Users_Log.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String line ;
                    while ((line=bufferedReader.readLine())!=null){
                        if (line.contains(uname+"\t")){
                            matched=true;
                            break;
                        }
                    }
                    fileReader.close();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                if (matched){
                      JOptionPane.showMessageDialog(null,"For");

                }else {
                    JOptionPane.showMessageDialog(null,"Not Found!");
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

        this.add(userId);

        this.add(delete_user);
        this.add(backButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);

    }


}

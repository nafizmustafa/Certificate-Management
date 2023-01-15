import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UserControl extends JFrame {
    UserControl(){
        JLabel text = new JLabel("Welcome To Certificate Management System");
        JLabel text2 = new JLabel("Which type of certificate do you want?");
        JButton graduation = new JButton("Graduation Certificate");
        JButton club = new JButton("Club Certificate");
        JButton blood = new JButton("Blood Certificate");
        JButton back = new JButton("Back");
        JButton logOut= new JButton("Log Out");



        text.setBounds(75,30,270,25);
        text2.setBounds(95,60,250,30);
        graduation.setBounds(95,120,200,30);
        graduation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Graduation graduate = null;
                try {
                    graduate = new Graduation();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                graduate.setVisible(true);
            }
        });

        club.setBounds(95,170,200,30);
        club.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Club club1= null;
                try {
                    club1 = new Club();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                club1.setVisible(true);
            }
        });
        blood.setBounds(95,220,200,30);
        blood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Blood blood1= null;
                try {
                    blood1 = new Blood();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                blood1.setVisible(true);
            }
        });
        back.setBounds(95,270,200,30);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                LogInForm logInForm = new LogInForm();
                logInForm.setVisible(true);

            }
        });
        logOut.setBounds(95,320,200,30);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstPage firstPage= new FirstPage();
                firstPage.setVisible(true);
            }
        });




        this.add(text);
        this.add(text2);
        this.add(graduation);
        this.add(club);
        this.add(blood);
        this.add(back);
        this.add(logOut);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);


    }
}

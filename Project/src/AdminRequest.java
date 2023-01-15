import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminRequest extends JFrame {
    AdminRequest(){
        JLabel text = new JLabel("Check requests for certificates");
        JButton graduation = new JButton("Graduation Request");
        JButton club = new JButton("Club Request");
        JButton blood = new JButton("Blood Request");
        JButton back = new JButton("Back");
        JButton logOut= new JButton("Log Out");



        text.setBounds(105,50,270,25);
        graduation.setBounds(95,100,200,30);
        graduation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath ="Graduate.txt";
                File file = new File(filePath);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                  //  String firstLine= br.readLine().trim();
                    String[] columnName =new String[] {"Name","Varsity","Department","Credit Complete","CGPA","ID"};
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame(" All Graduate Request Data in Table");
                    frame.add(scrollPane);
                    frame.setSize(420, 420);
                    frame.setVisible(true);


                    model.setColumnIdentifiers(columnName);

                    Object[] tableLines= br.lines().toArray();
                    for (int i=0;i<tableLines.length;i++){
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("\t");
                        model.addRow(dataRow);
                    }
                }catch (Exception ex){
                    Logger.getLogger(AdminRequest.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        });


        club.setBounds(95,150,200,30);
        club.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath ="Club.txt";
                File file = new File(filePath);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine= br.readLine().trim();
                    String[] columnName =new String[] {"Name","Club Name","Position or Post","Work Experience"};
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame("All Club Request Data in Table");
                    frame.add(scrollPane);
                    frame.setSize(420, 420);
                    frame.setVisible(true);


                    model.setColumnIdentifiers(columnName);

                    Object[] tableLines= br.lines().toArray();
                    for (int i=0;i<tableLines.length;i++){
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("\t");
                        model.addRow(dataRow);
                    }
                }catch (Exception ex){
                    Logger.getLogger(AdminRequest.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        });


        blood.setBounds(95,200,200,30);
        blood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath ="Blood.txt";
                File file = new File(filePath);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine= br.readLine().trim();
                    String[] columnName =new String[] {"Name","Age","Blood Group"};
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame(" All Blood Request Data in Table");
                    frame.add(scrollPane);
                    frame.setSize(420, 420);
                    frame.setVisible(true);


                    model.setColumnIdentifiers(columnName);

                    Object[] tableLines= br.lines().toArray();
                    for (int i=0;i<tableLines.length;i++){
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("\t");
                        model.addRow(dataRow);
                    }
                }catch (Exception ex){
                    Logger.getLogger(AdminRequest.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        });

        back.setBounds(95,250,200,30);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminControl adminControl = new AdminControl();
                adminControl.setVisible(true);

            }
        });
        logOut.setBounds(95,300,200,30);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstPage firstPage= new FirstPage();
                firstPage.setVisible(true);
            }
        });




        this.add(text);
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

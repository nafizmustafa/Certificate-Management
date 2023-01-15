import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminControl extends JFrame {
    AdminControl(){
        JLabel text = new JLabel("Welcome To Admin page");
        JButton request = new JButton("User Request");
        JButton add = new JButton("Add User");
        JButton search = new JButton("Search User");
        JButton user = new JButton("All Users");
        JButton back = new JButton("Back");
        JButton logOut= new JButton("Log Out");



        text.setBounds(130,30,270,40);


        request.setBounds(95,80,200,25);
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminRequest adminRequest= new AdminRequest();
                adminRequest.setVisible(true);
            }
        });
        add.setBounds(95,130,200,25);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminAdd adminAdd = new AdminAdd();
                adminAdd.setVisible(true);
            }
        });

        search.setBounds(95,180,200,25);
        search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminSearch adminSearch = new AdminSearch();
                adminSearch.setVisible(true);


            }
        });
        user.setBounds(95,230,200,25);
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath ="Users_Log.txt";
                File file = new File(filePath);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine= br.readLine().trim();
                    String[] columnName =new String[] {"Name","Age"};
                    DefaultTableModel model = new DefaultTableModel();
                    JTable table = new JTable(model);
                    JScrollPane scrollPane = new JScrollPane(table);
                    JFrame frame = new JFrame(" All Users Data in Table");
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
        back.setBounds(95,280,200,25);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AdminLogIn adminLogIn = new AdminLogIn();
                adminLogIn.setVisible(true);


            }
        });
        logOut.setBounds(95,330,200,25);
        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                FirstPage firstPage= new FirstPage();
                firstPage.setVisible(true);
            }
        });






        this.add(text);
        this.add(add);
        this.add(search);
        this.add(request);
        this.add(back);
        this.add(user);
        this.add(logOut);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Certificate Management System");
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);


    }
}

package student.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;


public class view_class extends JFrame{
    Choice sturollno;
    JTable table;
    view_class(){

        setSize(900,650);
        setLocation(200, 50);
        setVisible(true);
        setLayout(null);

        getContentPane().setBackground(new Color(120,120,130));
        JLabel search = new JLabel("Search by Student Rollno");
        search.setBounds(20, 10, 170, 30);
        add(search);

        sturollno = new Choice();
        sturollno.setBounds(200, 10, 100, 30);
        add(sturollno);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                sturollno.add(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();       
        }

    }
    public static void main(String[] args) {
        new view_class();
        
    }
}

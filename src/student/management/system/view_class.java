package student.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class view_class extends JFrame{
    Choice sturollno;
    view_class(){

        getContentPane().setBackground(new Color(120,117,120));
        JLabel search = new JLabel("Search by Student Rollno");
        search.setBounds(20, 0, 150, 30);
        add(search);

        sturollno = new Choice();
        sturollno.setBounds(200, 0, 50, 30);
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

        setSize(900,650);
        setLocation(200, 50);
        setVisible(true);
        setLayout(null);

    }
    public static void main(String[] args) {
        new view_class();
        
    }
}

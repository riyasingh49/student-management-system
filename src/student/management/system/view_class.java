package student.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class view_class extends JFrame implements ActionListener {
    Choice sturollno;
    JTable table;
    JButton print, back, searchbtn, update;

    view_class() {

        setSize(900, 650);
        setLocation(200, 50);
        setVisible(true);
        setLayout(null);

        getContentPane().setBackground(new Color(120, 120, 130));
        JLabel search = new JLabel("Search by Student Rollno");
        search.setBounds(20, 10, 170, 30);
        add(search);

        sturollno = new Choice();
        sturollno.setBounds(200, 10, 100, 30);
        add(sturollno);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while (resultSet.next()) {
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

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0, 100, 900, 650);
        add(jp);

        searchbtn = new JButton("Search");
        searchbtn.setBounds(30, 70, 80, 30);
        searchbtn.addActionListener(this);
        add(searchbtn);

        print = new JButton("Print");
        print.setBounds(130, 70, 80, 30);
        print.addActionListener(this);
        add(print);

        back = new JButton("Back");
        back.setBounds(230, 70, 80, 30);
        back.addActionListener(this);
        add(back);

        update = new JButton("Update");
        update.setBounds(330, 70, 80, 30);
        update.addActionListener(this);
        add(update);
    }

    public static void main(String[] args) {
        new view_class();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchbtn) {
            String query = "select * from student where rollno = '" + sturollno.getSelectedItem() + "'";
            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.getStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if(e.getSource() == update){
            try {
                setVisible(false);
                new update_student(sturollno.getSelectedItem());
            } catch (Exception E) {
                E.printStackTrace();
            }
            
        }else{
            try {
                setVisible(false);
                new main_class();
            } catch (Exception E) {   
                E.printStackTrace();
                     }
        }
    }
}

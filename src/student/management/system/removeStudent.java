package student.management.system;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class removeStudent extends JFrame {
    Choice sturollno;
    JButton delete, back;

    removeStudent() {

        JLabel label = new JLabel("Student Rollno");
        label.setBounds(50, 50, 150, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(label);

        sturollno = new Choice();
        sturollno.setBounds(200, 50, 100, 30);
        add(sturollno);

        try {
            conn c = new conn();
            String query = "select * from student";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                sturollno.add(resultSet.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(50, 100, 100, 30);
        name.setFont(new Font("tahoma", Font.BOLD, 15));
        add(name);

        JLabel nameval = new JLabel();
        nameval.setBounds(200, 100, 150, 30);

        add(nameval);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(50, 150, 150, 30);
        phone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(phone);

        JLabel phoneval = new JLabel();
        phoneval.setBounds(200, 150, 150, 30);
        add(phoneval);

        JLabel email = new JLabel("Email");
        email.setBounds(50, 200, 150, 30);
        email.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(email);

        JLabel emailval = new JLabel();
        emailval.setBounds(200, 200, 150, 30);
        add(emailval);

        try {
            conn c = new conn();
            String query = "select * from student where rollno = '" + sturollno.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                nameval.setText(resultSet.getString("name"));
                phoneval.setText(resultSet.getString("phone"));
                emailval.setText(resultSet.getString("email"));

            }

        } catch (Exception E) {
            E.printStackTrace();
        }

        sturollno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                try {
                    conn c = new conn();
                    String query = "select * from student where rollno = '" + sturollno.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);
                    while (resultSet.next()) {
                        nameval.setText(resultSet.getString("name"));
                        phoneval.setText(resultSet.getString("phone"));
                        emailval.setText(resultSet.getString("email"));

                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(220, 300, 100, 30);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(370, 300, 100, 30);
        add(back);

        
        setSize(900, 450);
        setLocation(200, 150);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new removeStudent();
    }

}
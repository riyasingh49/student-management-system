package student.management.system;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class removeStudent extends JFrame implements ActionListener {
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
        delete.addActionListener(this);
        add(delete);

        back = new JButton("BACK");
        back.setBounds(370, 300, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/trash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550,50,200,200);
        add(image);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image i22 = i11.getImage().getScaledInstance(900, 450, Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel img = new JLabel(i33);
        img.setBounds(0,0,900,450);
        add(img);

        setSize(900, 450);
        setLocation(200, 150);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new removeStudent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == delete){
        try {
            conn c = new conn();
            String query = "delete from student where rollno ='" + sturollno.getSelectedItem() + "'";
            c.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Student Deleted successfully");
            setVisible(false);
            new main_class();            
        } catch (Exception E) {
            E.printStackTrace();
        }
       }else{
        setVisible(false);
        new main_class();
       }
    }

}
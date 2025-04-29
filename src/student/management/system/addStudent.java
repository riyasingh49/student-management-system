package student.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addStudent extends JFrame {
    JTextField tname, tfname, tcourse, tbranch, tyear, trollno, taddress, tphone, temail, tdob;

    addStudent(){
        getContentPane().setBackground(new Color(203,215,188));

        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(350, 30,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(70, 150,150 , 30);
        name.setFont(new Font("San serif", Font.BOLD,20));
        add(name);

        JTextField tname = new JTextField();
        tname.setBounds(170, 150, 150, 30);
        tname.setBackground(new Color(203, 215, 188));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(450, 150,150 , 30);
        fname.setFont(new Font("San serif", Font.BOLD,20));
        add(fname);

        JTextField tfname = new JTextField();
        tfname.setBounds(650, 150, 150, 30);
        tfname.setBackground(new Color(203, 215, 188));
        add(tfname);

        setSize(900, 700);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addStudent();
    }
}

package student.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class addStudent extends JFrame {
    JTextField tname, tfname, tcourse, tbranch, tyear, trollno, taddress, tphone, temail;
    JDateChooser tdob;
    JComboBox branchBox;


    addStudent(){
        getContentPane().setBackground(new Color(203,215,188));

        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(350, 30,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(70, 150,150 , 30);
        name.setFont(new Font("San serif", Font.BOLD,15));
        add(name);

        JTextField tname = new JTextField();
        tname.setBounds(250, 150, 150, 30);
        tname.setBackground(new Color(203, 215, 188));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(500, 150,150 , 30);
        fname.setFont(new Font("San serif", Font.BOLD,15));
        add(fname);

        JTextField tfname = new JTextField();
        tfname.setBounds(650, 150, 150, 30);
        tfname.setBackground(new Color(203, 215, 188));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(70, 200,150 , 30);
        dob.setFont(new Font("San serif", Font.BOLD,15));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(250, 200, 150, 30);
        tdob.setBackground(new Color(203, 215, 188));
        add(tdob);

        JLabel course = new JLabel("Course");
        course.setBounds(500, 200, 150, 30);
        course.setFont(new Font("San serif", Font.BOLD,15));
        add(course);

        JTextField tcourse = new JTextField();
        tcourse.setBounds(650, 200, 150, 30);
        tcourse.setBackground(new Color(203, 215, 188));
        add(tcourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(70, 250, 150, 30);
        branch.setFont(new Font("Sans serif",Font.BOLD,15));
        add(branch);

        

        JTextField tbranch = new JTextField();
        tbranch.setBounds(250, 250, 150, 30);
        tbranch.setBackground(new Color(203,215,188));
        add(tbranch);

        JLabel year = new JLabel("Current year");
        year.setBounds(500, 250, 150, 30);
        year.setFont(new Font("Sans serif", Font.BOLD, 15));
        add(year);

        JTextField tyear = new JTextField();
        tyear.setBounds(650, 250, 150, 30);
        tyear.setBackground(new Color(203,215,188));
        add(tyear);

        JLabel rollno = new JLabel("Roll Number");
        rollno.setBounds(70, 300, 150, 30);
        rollno.setFont(new Font("Sans serif", Font.BOLD,15));
        add(rollno);

        JTextField trollno = new JTextField();
        trollno.setBounds(250, 300, 150, 30);
        trollno.setBackground(new Color(203,215,188));
        add(trollno);

        JLabel address = new JLabel("Address");
        address.setBounds(500, 300, 150, 30);
        address.setFont(new Font("Sans serif",Font.BOLD,15));
        add(address);

        JTextField taddress = new JTextField();
        taddress.setBounds(650, 300, 150, 30);
        taddress.setBackground(new Color(203,215,188));
        add(taddress);

        setSize(900, 700);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addStudent();
    }
}

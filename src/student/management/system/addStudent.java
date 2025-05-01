package student.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class addStudent extends JFrame implements ActionListener{
    JTextField tname, tfname, tcourse, tbranch, tyear, trollno, taddress, tphone, temail;
    JDateChooser tdob;
    JComboBox branchBox;
    JButton add,back;


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

        String[] branches = {"SELECT","CSE","IT","MECHANICAL","CIVIL","ELECTRICAL","ECE","CHEMICAL","BIO-MEDICAL","OTHER"};
        branchBox = new JComboBox(branches);
        branchBox.setBounds(250, 250, 150, 30);
        branchBox.setBackground(new Color(203, 225, 185));
        add(branchBox);

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

        JLabel email = new JLabel("Email");
        email.setBounds(70, 350, 150, 30);
        email.setFont(new Font("Sans serif",Font.BOLD,15));
        add(email);

        JTextField temail = new JTextField();
        temail.setBounds(250, 350, 150, 30);
        temail.setBackground(new Color(203,215,188));
        add(temail);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(500, 350, 150, 30);
        phone.setFont(new Font("Sans serif",Font.BOLD,15));
        add(phone);

        JTextField tphone = new JTextField();
        tphone.setBounds(650, 350, 150, 30);
        tphone.setBackground(new Color(203,215,188));
        add(tphone);

        add = new JButton("ADD");
        add.setBounds(250, 450, 150, 40);
        add.setForeground(Color.black);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(450, 450, 150, 40);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);


        setSize(900, 650);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String course = tcourse.getText();
            String branch = (String) branchBox.getSelectedItem();
            String year = tyear.getText();
            String rollno = trollno.getText();
            String address = taddress.getText();
            String email = temail.getText();
            String phone = tphone.getText();

            try {
                conn c = new conn();
                String query = "insert into student values('"+name+"','"+fname+"','"+dob+"','"+course+"','"+branch+"','"+year+"','"+rollno+"','"+address+"','"+email+"','"+phone+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully!");
                setVisible(false);
                new main_class();

            } catch (Exception E) {
                E.printStackTrace();
                 }
        }
    }
    public static void main(String[] args) {
        new addStudent();
    }
   
}

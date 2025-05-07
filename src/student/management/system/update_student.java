package student.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class update_student extends JFrame implements ActionListener{
    JTextField tname, tfname, tcourse, tbranch, tyear, trollno, taddress, tphone, temail;
    JButton update,back;
    JDateChooser tdob;
    JComboBox branchBox;
    // String number;
    update_student (String number){

        getContentPane().setBackground(new Color(203,215,188));

        JLabel heading = new JLabel("Add Student Detail");
        heading.setBounds(350, 30,500,50);
        heading.setFont(new Font("Serif", Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(70, 150,150 , 30);
        name.setFont(new Font("San serif", Font.BOLD,15));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(250, 150, 150, 30);
        tname.setBackground(new Color(203, 215, 188));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(500, 150,150 , 30);
        fname.setFont(new Font("San serif", Font.BOLD,15));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(650, 150, 150, 30);
        tfname.setBackground(new Color(203, 215, 188));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(70, 200,150 , 30);
        dob.setFont(new Font("San serif", Font.BOLD,15));
        add(dob);

       JLabel tdob = new JLabel();
       tdob.setBounds(250, 200, 150, 30);
       dob.setFont(new Font("Sans serif",Font.BOLD,15));
       add(tdob);

        JLabel course = new JLabel("Course");
        course.setBounds(500, 200, 150, 30);
        course.setFont(new Font("San serif", Font.BOLD,15));
        add(course);

        tcourse = new JTextField();
        tcourse.setBounds(650, 200, 150, 30);
        tcourse.setBackground(new Color(203, 215, 188));
        add(tcourse);

        JLabel branch = new JLabel("Branch");
        branch.setBounds(70, 250, 150, 30);
        branch.setFont(new Font("Sans serif",Font.BOLD,15));
        add(branch);

        tbranch = new JTextField();
        tbranch.setBounds(250, 250, 150, 30);
        tbranch.setBackground(new Color(203, 215, 188));
        add(tbranch);

        JLabel year = new JLabel("Current year");
        year.setBounds(500, 250, 150, 30);
        year.setFont(new Font("Sans serif", Font.BOLD, 15));
        add(year);

        tyear = new JTextField();
        tyear.setBounds(650, 250, 150, 30);
        tyear.setBackground(new Color(203,215,188));
        add(tyear);

        JLabel rollno = new JLabel("Roll Number");
        rollno.setBounds(70, 300, 150, 30);
        rollno.setFont(new Font("Sans serif", Font.BOLD,15));
        add(rollno);

        JLabel trollno = new JLabel();
        trollno.setBounds(250, 300, 150, 30);
        trollno.setBackground(new Color(203,215,188));
        add(trollno);

        JLabel address = new JLabel("Address");
        address.setBounds(500, 300, 150, 30);
        address.setFont(new Font("Sans serif",Font.BOLD,15));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(650, 300, 150, 30);
        taddress.setBackground(new Color(203,215,188));
        add(taddress);

        JLabel email = new JLabel("Email");
        email.setBounds(70, 350, 150, 30);
        email.setFont(new Font("Sans serif",Font.BOLD,15));
        add(email);

        temail = new JTextField();
        temail.setBounds(250, 350, 150, 30);
        temail.setBackground(new Color(203,215,188));
        add(temail);

        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(500, 350, 150, 30);
        phone.setFont(new Font("Sans serif",Font.BOLD,15));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(650, 350, 150, 30);
        tphone.setBackground(new Color(203,215,188));
        add(tphone);

        try {
            conn c = new conn();
            String query = "select * from student where rollno = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while(resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                tcourse.setText(resultSet.getString("course"));
                tbranch.setText(resultSet.getString("branch"));
                tyear.setText(resultSet.getString("year"));
                trollno.setText(resultSet.getString("rollno"));
                taddress.setText(resultSet.getString("address"));
                temail.setText(resultSet.getString("email"));
                tphone.setText(resultSet.getString("phone"));


            }
        } catch (Exception e) {
            e.printStackTrace();
                }

        update = new JButton("UPDATE");
        update.setBounds(250, 450, 150, 40);
        update.setForeground(Color.black);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(450, 450, 150, 40);
        back.setForeground(Color.black);
        back.addActionListener( this);
        add(back);


        setSize(900, 650);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    
    }
    public static void main(String[] args) {
        new update_student("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String fname = tfname.getText();
            String course = tcourse.getText();
            String branch = tbranch.getText();
            String year = tyear.getText();
            String address = taddress.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            String rollno = trollno.getText();

            try {
                conn c = new conn();
                String query = "update student set fname = '"+fname+"', course = '"+course+"', branch = '"+branch+ "', year = '"+year+"', address = '"+address+"',email = '"+email+"', phone = '"+phone+"' where rollno = '"+rollno+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated Successfully!");
                setVisible(false);
                new view_class();
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else{
            setVisible(false);
            new view_class();
        }
    }
}

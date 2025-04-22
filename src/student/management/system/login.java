package student.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener{

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        // login.setBackground(Color.blue);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150,190,150,30);
        // back.setBackground(Color.pink);
        back.setForeground(Color.black);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/lock.jpeg"));
        Image i21 = i11.getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH
        );
        ImageIcon i31 = new ImageIcon(i21);
        JLabel imgg = new JLabel(i31);
        imgg.setBounds(350,60,150,150);
        add(imgg);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setSize(600,300);
        setLocation(350,200);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
            try {
                String username = tusername.getText();
                String password = tpassword.getSelectedText();

                conn conn = new conn();
                String query = "select * from login where username = '"+ username +"' and password = '"+password+"'"; 
                ResultSet resultSet = conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else{

                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
                
            } catch (Exception E) {
               
                E.printStackTrace();
            }
        }else{
            System.exit(49);
        }
        
    }
    public static void main(String[] args) {
        new login();
        
    }
}

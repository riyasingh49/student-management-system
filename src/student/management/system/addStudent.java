package student.management.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class addStudent extends JFrame {

    addStudent(){
        getContentPane().setBackground(new Color(203,215,188));

        JLabel heading = new JLabel("Add Student Details");
        heading.setBounds(350, 30,500,50);
        heading.setFont(new Font("Times new Roman", Font.BOLD,25));
        add(heading);

        setSize(900, 700);
        setLayout(null);
        setLocation(200,50);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addStudent();
    }
}

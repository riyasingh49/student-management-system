package student.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class main_class extends JFrame {

    main_class() {

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.png"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1120, 630);
        add(img);

        JLabel heading = new JLabel("Student Management System");
        heading.setBounds(340, 50, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        img.add(heading);

        JButton button = new JButton("Add Student");
        button.setBounds(300, 150, 150, 40);
        button.setForeground(Color.WHITE); // text color
        button.setBackground(Color.DARK_GRAY); // background
        button.setBorderPainted(false); // hide border
        button.setFocusPainted(false); // remove focus outline
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addStudent();
                setVisible(false);
            }
        });
        img.add(button);

        JButton view = new JButton("View Student");
        view.setBounds(600, 150, 150, 40);
        view.setForeground(Color.WHITE); // text color
        view.setBackground(Color.DARK_GRAY); // background
        view.setBorderPainted(false); // hide border
        view.setFocusPainted(false); // remove focus outline
        view.setContentAreaFilled(true);
        view.setOpaque(true);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new view_class();
                setVisible(false);
            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Student");
        rem.setBounds(450, 250, 150, 40);
        rem.setForeground(Color.WHITE); // text color
        rem.setBackground(Color.DARK_GRAY); // background
        rem.setBorderPainted(false); // hide border
        rem.setFocusPainted(false); // remove focus outline
        rem.setContentAreaFilled(true);
        rem.setOpaque(true);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        img.add(rem);

        setSize(1120, 630);
        setVisible(true);
        setLayout(null);
        setLocation(70, 100);

    }

    public static void main(String[] args) {
        new main_class();
    }
}

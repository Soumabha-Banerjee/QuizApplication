package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Login implements ActionListener {
    final JFrame frame;
    final JButton rules;
    final JButton close;
    final JTextField tfName;

    public Login() {
        // Testing
        System.out.println("Login Page");

        // Creating JFrame
        frame = new JFrame();
        frame.setTitle("Quiz Application");
        frame.setSize(1000, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating ImageIcon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg"));
        // Creating Image Label to Add Image in JFrame
        JLabel imgLbl = new JLabel(icon);
        imgLbl.setBounds(0, 0, 550, 500);
        frame.add(imgLbl);

        // Creating Heading
        JLabel heading = new JLabel("Java Quiz");
        heading.setBounds(700, 60, 300, 45);
        // Setting Font
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading.setForeground(new Color(110, 100, 254));
        frame.add(heading);

        // Creating Label for Text Field
        JLabel txtLbl = new JLabel("Enter Your Name");
        txtLbl.setBounds(725, 150, 300, 20);
        // Setting Font
        txtLbl.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        txtLbl.setForeground(new Color(110, 100, 254));
        frame.add(txtLbl);

        // Creating Text Field
        tfName = new JTextField();
        tfName.setBounds(650, 200, 300, 25);
        tfName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        frame.add(tfName);

        // Creating Rules Button
        rules = new JButton("Rules");
        rules.setBounds(650, 270, 120, 25);
        rules.setBackground(new Color(100, 100, 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        frame.add(rules);

        // Creating Close Button
        close = new JButton("Close");
        close.setBounds(830, 270, 120, 25);
        close.setBackground(new Color(100, 100, 254));
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        frame.add(close);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rules) {
            System.out.println("Rules Button Clicked");
            String name = tfName.getText();
            frame.setVisible(false);
            try {
                new Rules(name);
            } catch (Exception exp) {
                System.out.println("Error Occured: " + exp);
            }
        }
        if (e.getSource() == close) {
            System.out.println("Close Button Clicked");
            frame.setVisible(false);
            // Closing The Application When Close Button is Clicked
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }
}

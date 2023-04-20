package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules implements ActionListener {
    final JFrame frame;
    final JButton start;
    final JButton back;
    final String name;

    public Rules(String name) {
        // Creating Frame
        frame = new JFrame();
        frame.setTitle("Rules");
        frame.setSize(800, 650);
        frame.setLocation(350, 100);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating Heading
        this.name = name;
        name = "Welcome " + this.name + " in Java Quiz";
        JLabel heading = new JLabel(name);
        heading.setBounds(50, 20, 700, 30);
        // Setting Font
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));
        heading.setForeground(new Color(110, 100, 254));
        frame.add(heading);

        // Creating Rules
        JLabel rules = new JLabel();
        rules.setBounds(20, 90, 700, 350);
        // Setting Font
        rules.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
        rules.setForeground(new Color(110, 100, 254));
        rules.setText("<html>"+
                "1. This is a basic Java Quiz based on basics of Java Programming" + "<br><br>" +
                "2. It has a total of 10 questions" + "<br><br>" +
                "3. Each questions is of 10 marks, so total number is 100 marks" + "<br><br>" +
                "4. There are three buttons - Next, 50-50 Lifeline, and Submit" + "<br><br>" +
                "5. You can click the Next button to go to the next question" + "<br><br>" +
                "6. You can click 50-50 Lifeline button which disables two incorrect options and You Can use it once" + "<br><br>" +
                "7. You can click the Submit button at the last question to submit the quiz" + "<br><br>" +
                "8. Each question has a timer of 20sec and automatically jumps to the next question if the time is up" + "<br><br>" +
                "9. If you don't click the Submit button the quiz is automatically submitted when the time is up" + "<br><br>" +
                "<html>");
        frame.add(rules);

        // Creating Back Button
        back = new JButton("Back");
        back.setBounds(250, 500, 100, 30);
        back.setBackground(new Color(100, 100, 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        frame.add(back);

        // Creating Start Button
        start = new JButton("Start");
        start.setBounds(400, 500, 100, 30);
        start.setBackground(new Color(100, 100, 254));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        frame.add(start);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            System.out.println("Start Button Clicked");
            frame.setVisible(false);
            try {
                new Quiz(this.name);
            } catch (Exception exp) {
                System.out.println("Error Occured: " + exp);
            }
        }
        if (e.getSource() == back) {
            System.out.println("Back Button Clicked");
            frame.setVisible(false);
            try {
                new Login();
            } catch (Exception exp) {
                System.out.println("Error Occured: " + exp);
            }
        }
    }
}

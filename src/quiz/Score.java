package quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Score extends JFrame implements ActionListener {
    public Score(int score, String userName) {
        setTitle("Your Score");
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT); // Scaling The Image
        i1 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(0, 200, 300, 250);
        add(image);

        // JLabel for Username
        JLabel heading = new JLabel("Thankyou " + userName + " for playing Java Quiz");
        heading.setBounds(45, 30, 700, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        heading.setForeground(new Color(110, 100, 254));
        add(heading);

        // JLabel for Score
        JLabel lblScore = new JLabel("Your score is " + score);
        lblScore.setBounds(350, 200, 300, 30);
        lblScore.setFont(new Font("Mongolian Baiti", Font.BOLD, 26));
        lblScore.setForeground(new Color(110, 100, 254));
        add(lblScore);

        // Creating Play Again Button
        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(380, 270, 120, 30);
        playAgain.setBackground(new Color(110, 100, 254));
        playAgain.setForeground(Color.WHITE);
        playAgain.addActionListener(this);
        add(playAgain);

        setVisible(true);
    }

    @Override
    // Overriding The actionPerformed Method
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}

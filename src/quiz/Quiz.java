package quiz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener {
    final JLabel qs, qsNo;
    final JButton next, lifeline, submit;
    final JRadioButton opt1, opt2, opt3, opt4;
    final ButtonGroup grpOpts;
    final String[][] questions = new String[10][5]; // Creating Questions 2D Array 10QS as Row 1QS, and It's 4Option as Column
    final String[][] answers = new String[10][1]; // Creating Answers 2D Array 10QS'S ANS as Row 1ANS as Column
    final String[][] userAns = new String[10][1]; // Creating 2D Array to Store User Answers
    final String userName;
    private int timer = 20; // Setting Timer to 20s Per QS
    private int ansGiven = 0; // Setting Whether Answer is Given or Not
    private int count = 0; // Setting User Question Number
    private int score = 0; // Score of The User

    public Quiz(String userName) {
        // Setting The Username
        this.userName = userName;

        // Creating Frame
        setTitle("Quiz");
        setSize(1440, 850);
        setLocation(50, 0);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating ImageIcon
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        // Creating Image Label to Add Image in JFrame
        JLabel imgLbl = new JLabel(icon);
        imgLbl.setBounds(0, 0, 1440, 390);
        add(imgLbl);

        // Setting Questions and Answers
        setQsAns();

        // Creating Question No
        qsNo = new JLabel();
        qsNo.setBounds(100, 450, 50, 30);
        // Setting Font
        qsNo.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        qsNo.setForeground(new Color(110, 100, 254));
        add(qsNo);

        // Creating Question
        qs = new JLabel();
        qs.setBounds(130, 450, 900, 30);
        // Setting Font
        qs.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        qs.setForeground(new Color(110, 100, 254));
        add(qs);

        // Creating Options
        opt1 = new JRadioButton();
        opt1.setBounds(150, 500, 500, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        opt2 = new JRadioButton();
        opt2.setBounds(150, 530, 500, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        opt3 = new JRadioButton();
        opt3.setBounds(150, 560, 500, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        opt4 = new JRadioButton();
        opt4.setBounds(150, 590, 500, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        // Grouping Options
        grpOpts = new ButtonGroup();
        grpOpts.add(opt1);
        grpOpts.add(opt2);
        grpOpts.add(opt3);
        grpOpts.add(opt4);

        // Creating Next Button
        next = new JButton("Next");
        next.setBounds(1100, 505, 200, 40);
        next.setBackground(new Color(100, 100, 254));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        // Creating Lifeline Button
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 565, 200, 40);
        lifeline.setBackground(new Color(100, 100, 254));
        lifeline.setForeground(Color.WHITE);
        lifeline.addActionListener(this);
        add(lifeline);

        // Creating Submit Button
        submit = new JButton("Submit");
        submit.setBounds(1100, 625, 200, 40);
        submit.setBackground(new Color(100, 100, 254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        // Starting Quiz By Setting Questions and Answers
        start(count);

        setVisible(true);
    }

    // This Method is Used to Store Questions, Options, and Answers
    private void setQsAns() {
        // Storing Questions
        questions[0][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        // Storing Answers
        answers[0][0] = "JDB";
        answers[1][0] = "int";
        answers[2][0] = "java.util package";
        answers[3][0] = "Marker Interface";
        answers[4][0] = "Heap memory";
        answers[5][0] = "Remote interface";
        answers[6][0] = "import";
        answers[7][0] = "Java Archive";
        answers[8][0] = "java.lang.StringBuilder";
        answers[9][0] = "Bytecode is executed by JVM";
    }

    // This is Overridden ActionPerformed Method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ansGiven = 1;
            if (grpOpts.getSelection() == null)
                userAns[count][0] = "";
            else
                userAns[count][0] = grpOpts.getSelection().getActionCommand();
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (e.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else  {
            ansGiven = 1;
            // Storing Which Option is Selected
            if (grpOpts.getSelection() == null)
                userAns[count][0] = "";
            else
                userAns[count][0] = grpOpts.getSelection().getActionCommand();
            // Calculating User's Score
            for (int i = 0; i < userAns.length; i++) {
                if (userAns[i][0].equals(answers[i][0]))
                    score = score + 10;
            }
            setVisible(false);
            new Score(score, userName);
        }
    }

    // This Method Calls Automatically to Update the JFrame
    public void paint(Graphics g) {
        super.paint(g);

        // Setting Up The Timer
        String time = "Time Left: " + timer + "sec";
        g.setColor(Color.GREEN);
        g.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));

        // Draw Time String on JFrame Until Time reaches 0
        if (timer >= 0) {
            // Setting Colour to Red if 5sec Left
            if (timer <= 5)
                g.setColor(Color.RED);
            // Drawing The Time String
            g.drawString(time, 1100, 480);
            // Decreasing Time After 1sec Using Multithreading and Recalls The Paint Method
            timer--;
            try {
                Thread.sleep(1000);
                repaint();
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }

        // If Answer is Given
        if (ansGiven == 1) {
            ansGiven = 0;
            timer = 20;
        }

        // If Time is Up
        else if (timer < 0) {
            timer = 20;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                // Storing Which Option is Selected
                if (grpOpts.getSelection() == null)
                    userAns[count][0] = "";
                else
                    userAns[count][0] = grpOpts.getSelection().getActionCommand();
                // Calculating User's Score
                for (int i = 0; i < userAns.length; i++) {
                    if (userAns[i][0].equals(answers[i][0]))
                        score = score + 10;
                }
                setVisible(false);
                new Score(score, userName);
            } else {
                opt1.setEnabled(true);
                opt2.setEnabled(true);
                opt3.setEnabled(true);
                opt4.setEnabled(true);
                // Storing Which Option is Selected
                if (grpOpts.getSelection() == null)
                    userAns[count][0] = "";
                else
                    userAns[count][0] = grpOpts.getSelection().getActionCommand();
                count++;
                start(count);
            }
        }
    }

    // This Method is Used to Set Questions and Options Dynamically
    private void start(int count) {
        //Setting Question Number
        qsNo.setText(count + 1 + ".");
        // Setting Question
        qs.setText(questions[count][0]);
        // Setting Options
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        // Clearing Selection of Previous Question
        grpOpts.clearSelection();
    }
}

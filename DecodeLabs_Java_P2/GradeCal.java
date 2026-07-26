// Import Swing and AWT libraries for creating the GUI.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// GradeCal is a GUI application that calculates
// total marks, average, percentage, and grade
// for five subjects.
public class GradeCal extends JFrame implements ActionListener {

    // Labels used in the application
    JLabel title;
    JLabel l1, l2, l3, l4, l5;

    // Text fields for entering subject marks
    JTextField t1, t2, t3, t4, t5;

    // Buttons for calculating and resetting the form
    JButton calculate, reset;

    // Labels used to display the calculated result
    JLabel totalLabel, averageLabel, percentageLabel, gradeLabel;

    // Constructor used to design and initialize the GUI
    GradeCal() {

        // Window settings
        setTitle("Student Grading Calculator");
        setSize(550, 550);
        setLayout(null);
        getContentPane().setBackground(new Color(220, 240, 255));

        // Main heading of the application
        title = new JLabel("STUDENT GRADING CALCULATOR");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(85, 20, 400, 30);
        add(title);

        // Creating labels and text fields for Subject 1
        l1 = new JLabel("Subject 1:");
        l1.setBounds(60, 80, 100, 25);
        add(l1);

        t1 = new JTextField();
        t1.setBounds(180, 80, 120, 25);
        add(t1);

        // Subject 2
        l2 = new JLabel("Subject 2:");
        l2.setBounds(60, 120, 100, 25);
        add(l2);

        t2 = new JTextField();
        t2.setBounds(180, 120, 120, 25);
        add(t2);

        // Subject 3
        l3 = new JLabel("Subject 3:");
        l3.setBounds(60, 160, 100, 25);
        add(l3);

        t3 = new JTextField();
        t3.setBounds(180, 160, 120, 25);
        add(t3);

        // Subject 4
        l4 = new JLabel("Subject 4:");
        l4.setBounds(60, 200, 100, 25);
        add(l4);

        t4 = new JTextField();
        t4.setBounds(180, 200, 120, 25);
        add(t4);

        // Subject 5
        l5 = new JLabel("Subject 5:");
        l5.setBounds(60, 240, 100, 25);
        add(l5);

        t5 = new JTextField();
        t5.setBounds(180, 240, 120, 25);
        add(t5);

        // Buttons with different colors for better appearance
        calculate = new JButton("Calculate");
        calculate.setBounds(80, 300, 140, 40);
        calculate.setBackground(new Color(0, 153, 76));
        calculate.setForeground(Color.WHITE);
        calculate.setFont(new Font("Arial", Font.BOLD, 14));
        calculate.addActionListener(this);
        add(calculate);

        reset = new JButton("Reset");
        reset.setBounds(260, 300, 140, 40);
        reset.setBackground(new Color(204, 0, 0));
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial", Font.BOLD, 14));
        reset.addActionListener(this);
        add(reset);

        // Labels that will display the final result
        totalLabel = new JLabel("Total Marks : ");
        totalLabel.setBounds(60, 370, 400, 25);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(totalLabel);

        averageLabel = new JLabel("Average : ");
        averageLabel.setBounds(60, 400, 400, 25);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(averageLabel);

        percentageLabel = new JLabel("Percentage : ");
        percentageLabel.setBounds(60, 430, 400, 25);
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(percentageLabel);

        gradeLabel = new JLabel("Grade : ");
        gradeLabel.setBounds(60, 460, 400, 25);
        gradeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(gradeLabel);

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display the window in the center of the screen
        setLocationRelativeTo(null);

        // Make the frame visible
        setVisible(true);
    }

    // This method runs whenever a button is clicked.
    @Override
    public void actionPerformed(ActionEvent e) {

        // Execute calculation when the Calculate button is pressed
        if (e.getSource() == calculate) {

            try {

                // Read marks entered by the user
                int s1 = Integer.parseInt(t1.getText());
                int s2 = Integer.parseInt(t2.getText());
                int s3 = Integer.parseInt(t3.getText());
                int s4 = Integer.parseInt(t4.getText());
                int s5 = Integer.parseInt(t5.getText());

                // Validate that each subject mark is between 0 and 100
                if (s1 < 0 || s1 > 100 ||
                        s2 < 0 || s2 > 100 ||
                        s3 < 0 || s3 > 100 ||
                        s4 < 0 || s4 > 100 ||
                        s5 < 0 || s5 > 100) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Marks!\nEach subject must be between 0 and 100.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }

                // Calculate total, average, and percentage
                int total = s1 + s2 + s3 + s4 + s5;
                double average = total / 5.0;
                double percentage = (total / 500.0) * 100;

                String grade;

                // Assign grade based on the percentage
                if (percentage >= 90) {
                    grade = "A+";
                } else if (percentage >= 80) {
                    grade = "A";
                } else if (percentage >= 70) {
                    grade = "B";
                } else if (percentage >= 60) {
                    grade = "C";
                } else if (percentage >= 50) {
                    grade = "D";
                } else {
                    grade = "FAIL";
                }

                // Display the calculated result on the screen
                totalLabel.setText("Total Marks : " + total + " / 500");
                averageLabel.setText("Average : " + String.format("%.2f", average));
                percentageLabel.setText("Percentage : " + String.format("%.2f", percentage) + "%");
                gradeLabel.setText("Grade : " + grade);

            } catch (NumberFormatException ex) {

                // Display an error if the user enters non-numeric values
                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid numeric marks only.",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Execute when the Reset button is pressed
        if (e.getSource() == reset) {

            // Clear all input fields and result labels
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");

            totalLabel.setText("Total Marks : ");
            averageLabel.setText("Average : ");
            percentageLabel.setText("Percentage : ");
            gradeLabel.setText("Grade : ");
        }
    }

    // Main method starting point of the program
    public static void main(String[] args) {

        // Create an object of the GradeCal class
        new GradeCal();
    }
}

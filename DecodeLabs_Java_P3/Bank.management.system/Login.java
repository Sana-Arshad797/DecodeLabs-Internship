package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet; // For handling database results

public class Login extends JFrame implements ActionListener {
    // Declaring UI elements globally
    JLabel label1, label2, label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton button1, button2, button3;

    public Login() {
        // Set the window frame title
        super("                                                                                               AL-YUSR DIGITAL BANKING SYSTEM ");

        setLayout(null); // Using absolute positioning (no layout manager)

        // Loading and resizing the main logo icon
        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image I2 = I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel image1 = new JLabel(I3);
        image1.setBounds(350, 10, 100, 100);
        add(image1);

        // Loading and resizing the card insert icon
        ImageIcon II1 = new ImageIcon(ClassLoader.getSystemResource("icons/Card insert.png"));
        Image II2 = II1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon II3 = new ImageIcon(II2);
        JLabel image2 = new JLabel(II3);
        image2.setBounds(630, 340, 100, 100);
        add(image2);

        // System Welcome Greeting
        label1 = new JLabel("WELCOME TO AL-YUSR DIGITAL BANKING SYSTEM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 18));
        label1.setBounds(140, 125, 600, 35);
        add(label1);

        // Card Number Input Label
        label2 = new JLabel("Card No:");
        label2.setFont(new Font("Ralway", Font.BOLD, 20));
        label2.setForeground(Color.black);
        label2.setBounds(150, 190, 375, 30);
        add(label2);

        // Card Number Text Field
        textField2 = new JTextField(15);
        textField2.setBounds(325, 190, 230, 30);
        textField2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textField2);

        // PIN Code Input Label
        label3 = new JLabel("PIN:");
        label3.setFont(new Font("Ralway", Font.BOLD, 20));
        label3.setForeground(Color.black);
        label3.setBounds(150, 230, 375, 30);
        add(label3);

        // Password Field for hidden PIN input
        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(325, 230, 230, 30);
        passwordField3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordField3);

        // Sign In Execution Button
        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.BLACK);
        button1.setBounds(330, 300, 100, 30);
        button1.addActionListener(this); // Register click event listener
        add(button1);

        // Form Reset Button
        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setBounds(450, 300, 100, 30);
        button2.addActionListener(this); // Register click event listener
        add(button2);

        // Registration Direct Button
        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setBounds(330, 350, 220, 30);
        button3.addActionListener(this); // Register click event listener
        add(button3);

        // Loading and setting background image
        ImageIcon III1 = new ImageIcon(ClassLoader.getSystemResource("icons/background.png"));
        Image III2 = III1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon III3 = new ImageIcon(III2);
        JLabel image3 = new JLabel(III3);
        image3.setBounds(0, 0, 850, 480);
        add(image3);

        // Push background image to the bottom layer
        getContentPane().setComponentZOrder(image3, getContentPane().getComponentCount() - 1);

        // Main Frame Sizing and Localization Setup
        setSize(850, 480);
        setLocation(280, 160);
        setVisible(true);
    }

    // Capture and handle user interface actions
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Action trigger for SIGN IN execution
            if (e.getSource() == button1) {
                Connn c = new Connn(); // Open database connection layer
                String cardnumber = textField2.getText(); // Extract Card input
                String pin = new String(passwordField3.getPassword()); // Extract PIN input

                // Matches exact column structural metadata: cardnum and pinnum
                String query = "select * from login where cardnum = '"+cardnumber+"' and pinnum = '"+pin+"'";

                ResultSet rs = c.statement.executeQuery(query); // Execute fetch query statement

                if (rs.next()) { // Database entry found and authenticated
                    setVisible(false); // Close present login view panel
                    new Mainclass(pin).setVisible(true); // Open core transactions window console
                } else { // Entry validation credentials fault mismatch
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }

                // Action trigger to wipe user entry data clean
            } else if (e.getSource() == button2) {
                textField2.setText(""); // Erase input field string elements
                passwordField3.setText("");

                // Action trigger to switch view interface to Registration Form
            } else if (e.getSource() == button3) {
                setVisible(false); // Close login panel view panel
                new Signup().setVisible(true); // Open primary signup personal page class
            }

        } catch (Exception E) {
            E.printStackTrace(); // Dump tracing data if pipeline breaks
        }
    }

    public static void main(String[] args) {
        new Login(); // Execution runtime instantiation initialization
    }
}

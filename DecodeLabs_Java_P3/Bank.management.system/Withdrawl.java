package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    // Global variables for user inputs and navigation buttons
    String pin;
    TextField textField;
    JButton b1, b2;

    // Constructor to set up the screen layout and items
    Withdrawl(String pin){
        this.pin = pin;

        // Frame settings
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        getContentPane().setBackground(Color.BLACK);

        // Setting up the ATM background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // Instruction labels on the screen
        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,180,700,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(460,220,400,35);
        l3.add(label2);

        // Input field for amount entry
        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,260,320,30);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        // Withdraw execution button setup
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700,330,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back action button setup
        b2 = new JButton("BACK");
        b2.setBounds(700,375,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setVisible(true);
    }

    // Function to handle click operations on buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Logic for clicking the withdraw button
            if(e.getSource() == b1) {
                String amount = textField.getText();
                Date date = new Date();

                // Validation check for empty text field input
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount");
                    return;
                }

                // Creating object of database connection handler class
                Connn c = new Connn();

                // Fetching all transaction rows to calculate current total balance
                ResultSet resultSet = c.statement.executeQuery(
                        "select * from withdraw1 where pin = '" + pin + "'"
                );

                int balance = 0;

                // Loop through rows: Add for 'Deposit' and Subtract for others
                while (resultSet.next()) {
                    if (resultSet.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                // Safety guard to avoid over-withdrawing cash funds
                if (balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Saving the new withdrawal record into the MySQL metadata table mapping
                String query = "insert into withdraw1 values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                // Navigation routing back to main home dashboard interface
                setVisible(false);
                new Mainclass(pin).setVisible(true);

                // Logic for clicking the back button navigation paths
            } else if (e.getSource() == b2) {
                setVisible(false);
                new Mainclass(pin).setVisible(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Dump line breaks tracking logs onto console stack line
        }
    }

    public static void main(String[] args) {
        new Withdrawl(""); // Frame debugger initiation entry
    }
}

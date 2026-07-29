package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    TextField textField;
    JButton b1, b2;

    // Constructor to initialize frame
    public Deposit(String pin){
        this.pin = pin;

        // ===== FRAME SETTINGS =====
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        getContentPane().setBackground(Color.BLACK);

        // ===== ATM BACKGROUND IMAGE =====
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // ===== INSTRUCTION LABEL =====
        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(460,170,500,35);
        l3.add(label1);

        // ===== INPUT TEXT FIELD =====
        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,220,320,30);
        textField.setFont(new Font("Raleway", Font.BOLD,22));
        l3.add(textField);

        // ===== BUTTON ACTIONS =====
        Color btnColor = new Color(65,125,128);

        // Deposit Action Button
        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,310,150,35);
        b1.setBackground(btnColor);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // Back Navigation Button
        b2 = new JButton("BACK");
        b2.setBounds(700,360,150,35);
        b2.setBackground(btnColor);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setVisible(true);
    }

    // Capture Button Click Operations
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String amount = textField.getText();
                Date date = new Date();

                // Validation check for empty input field
                if (amount.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                    return;
                }

                // Initializing custom database connection handler class
                Connn c = new Connn();

                // Appending explicit data values directly into your MySQL 'withdraw1' metadata table structure
                String query = "insert into withdraw1 values('"+pin+"', '"+date+"','Deposit', '"+amount+"')";
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");

                setVisible(false);
                new Mainclass(pin).setVisible(true); // Launch dashboard and set visible mapping true

            } else if (e.getSource() == b2) {
                setVisible(false);
                new Mainclass(pin).setVisible(true); // Direct navigation back to primary application screen dashboard
            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Dump errors directly onto standard terminal framework stack lines
        }
    }

    // Local standard platform debug entry point
    public static void main(String[] args) {
        new Deposit("");
    }
}

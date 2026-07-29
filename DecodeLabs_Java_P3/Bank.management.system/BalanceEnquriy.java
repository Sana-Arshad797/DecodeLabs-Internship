package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {

    String pin;
    JLabel label2;
    JButton b1;

    // Constructor to render UI layout components
    BalanceEnquriy(String pin){
        this.pin = pin;

        // ===== FRAME SETTINGS =====
        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        getContentPane().setBackground(Color.BLACK);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1550,830);
        add(l3);

        // TITLE
        JLabel label1 = new JLabel("YOUR CURRENT BALANCE IS Rs");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(420,180,700,35);
        l3.add(label1);

        // BALANCE LABEL DISPLAY
        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 22));
        label2.setBounds(420,220,400,35);
        l3.add(label2);

        // BACK BUTTON
        b1 = new JButton("BACK");
        b1.setBounds(700,320,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        // ===== TOTAL BALANCE CALCULATION ENGINE =====
        int balance = 0;

        try{
            Connn c = new Connn();

            ResultSet resultSet = c.statement.executeQuery(
                    "select * from withdraw1 where pin = '"+pin+"'"
            );

            while (resultSet.next()){
                // Read exact row updates cleanly checking matching validation structures
                if (resultSet.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        // Set value cleanly onto display panel string context
        label2.setText(String.valueOf(balance));

        setVisible(true);
    }

    // Capture actionable window change navigation events
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); // Close present balance query frame interface
        new Mainclass(pin).setVisible(true); // Ensure active destination frame stays visible cleanly
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}

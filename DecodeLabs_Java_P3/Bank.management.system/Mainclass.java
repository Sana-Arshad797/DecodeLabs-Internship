package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainclass extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Mainclass(String pin){
        this.pin = pin;

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

        JLabel label = new JLabel("PLEASE SELECT YOUR TRANSACTION");
        label.setBounds(380,160,800,40);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,20));
        l3.add(label);


        Color btnColor = new Color(65,125,128);

        int w = 220;
        int h = 40;


        b1 = new JButton("DEPOSIT");
        b1.setBounds(380,240,w,h);
        styleButton(b1, btnColor);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setBounds(720,240,w,h);
        styleButton(b2, btnColor);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBounds(380,290,w,h);
        styleButton(b3, btnColor);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBounds(720,290,w,h);
        styleButton(b4, btnColor);
        l3.add(b4);


        b5 = new JButton("PIN CHANGE");
        b5.setBounds(380,340,w,h);
        styleButton(b5, btnColor);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBounds(720,340,w,h);
        styleButton(b6, btnColor);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setBounds(550,400,200,40);
        styleButton(b7, btnColor);
        l3.add(b7);

        setVisible(true);
    }

    private void styleButton(JButton b, Color c){
        b.setForeground(Color.WHITE);
        b.setBackground(c);
        b.setFont(new Font("System", Font.BOLD, 14));
        b.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){
            new Bank.management.system.Deposit(pin);
            setVisible(false);
        } else if (e.getSource() == b2){
            new Bank.management.system.Withdrawl(pin);
            setVisible(false);
        } else if (e.getSource() == b3){
            new Bank.management.system.Fastcash(pin);
            setVisible(false);
        } else if (e.getSource() == b4){
            new Bank.management.system.mini(pin);
            setVisible(false);
        } else if (e.getSource() == b5){
            new Bank.management.system.Pin(pin);
            setVisible(false);
        } else if (e.getSource() == b6){
            new Bank.management.system.BalanceEnquriy(pin);
            setVisible(false);
        } else if (e.getSource() == b7){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Mainclass("");
    }
}

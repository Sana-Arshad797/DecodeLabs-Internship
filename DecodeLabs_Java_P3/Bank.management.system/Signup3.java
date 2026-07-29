package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    Signup3(String formno) {

        this.formno = formno;

        setLayout(null);

        // LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        JLabel logo = new JLabel(new ImageIcon(i2));
        logo.setBounds(20, 10, 90, 90);
        add(logo);

        // TITLE
        JLabel title = new JLabel("Account Details - Page 3");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(250, 30, 300, 30);
        add(title);

        JLabel form = new JLabel("Form No: " + formno);
        form.setBounds(600, 20, 200, 20);
        add(form);

        // ACCOUNT TYPE
        JLabel acc = new JLabel("Account Type");
        acc.setBounds(100, 120, 150, 25);
        add(acc);

        r1 = new JRadioButton("Savings Account");
        r1.setBounds(100, 160, 150, 25);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setBounds(280, 160, 150, 25);
        add(r2);

        r3 = new JRadioButton("Business Account");
        r3.setBounds(100, 190, 150, 25);
        add(r3);

        r4 = new JRadioButton("Fixed Deposit");
        r4.setBounds(280, 190, 150, 25);
        add(r4);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);

        // CARD INFO (DISPLAY ONLY)
        JLabel card = new JLabel("Card Number (Auto Generated)");
        card.setBounds(100, 240, 250, 25);
        add(card);

        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-XXXX");
        cardno.setBounds(350, 240, 250, 25);
        add(cardno);

        JLabel pin = new JLabel("PIN (Auto Generated)");
        pin.setBounds(100, 270, 250, 25);
        add(pin);

        JLabel pinno = new JLabel("XXXX");
        pinno.setBounds(350, 270, 250, 25);
        add(pinno);

        // SERVICES
        JLabel service = new JLabel("Services Required");
        service.setBounds(100, 310, 200, 25);
        add(service);

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(100, 350, 150, 25);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(280, 350, 150, 25);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(100, 380, 150, 25);
        add(c3);

        c4 = new JCheckBox("SMS Alerts");
        c4.setBounds(280, 380, 150, 25);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(100, 410, 150, 25);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBounds(280, 410, 150, 25);
        add(c6);

        // DECLARATION
        c7 = new JCheckBox("I confirm all details are correct", true);
        c7.setBounds(100, 450, 400, 25);
        add(c7);

        // BUTTONS
        submit = new JButton("SUBMIT");
        submit.setBounds(250, 520, 120, 35);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(400, 520, 120, 35);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // FRAME SETTINGS (MATCH WITH OTHER PAGES)
        getContentPane().setBackground(new Color(244, 229, 121, 218));
        setSize(700, 600);
        setLocation(400, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submit) {

            String atype = null;

            if (r1.isSelected()) atype = "Savings Account";
            else if (r2.isSelected()) atype = "Current Account";
            else if (r3.isSelected()) atype = "Business Account";
            else if (r4.isSelected()) atype = "Fixed Deposit";

            if (atype == null) {
                JOptionPane.showMessageDialog(null, "Please select account type");
                return;
            }

            try {
                Random ran = new Random();

                long cardNum = Math.abs(ran.nextLong() % 9000000000000000L) + 1000000000000000L;
                long pinNum = Math.abs(ran.nextInt(9000) + 1000);

                String services = "";

                if (c1.isSelected()) services += "ATM Card ";
                if (c2.isSelected()) services += "Internet Banking ";
                if (c3.isSelected()) services += "Mobile Banking ";
                if (c4.isSelected()) services += "SMS Alerts ";
                if (c5.isSelected()) services += "Cheque Book ";
                if (c6.isSelected()) services += "E-Statement ";

                Bank.management.system.Connn c = new Bank.management.system.Connn();

                String q1 = "insert into signupthree values('" + formno + "','" + atype + "','" + cardNum + "','" + pinNum + "','" + services + "')";
                String q2 = "insert into login values('" + formno + "','" + cardNum + "','" + pinNum + "')";

                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,
                        "Card Number: " + cardNum + "\nPIN: " + pinNum);

                new Bank.management.system.Deposit(String.valueOf(pinNum));
                setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}

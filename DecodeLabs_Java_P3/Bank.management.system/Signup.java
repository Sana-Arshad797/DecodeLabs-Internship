package Bank.management.system;

import Bank.management.system.Connn;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1, r2, m1, m2, m3;
    JButton next;

    JTextField textName, textFname, textEmail, textAdd, textcity, textState, textPin;
    JDateChooser dateChooser;

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    JPanel panel;
    Signup() {

        super("APPLICATION FORM");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(850, 750)); // 🔥 FIXED SIZE (SMALL)
        panel.setBackground(new Color(222, 255, 228));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(25, 10, 90, 90);
        panel.add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 30));
        panel.add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Ralway", Font.BOLD, 18));
        label2.setBounds(330, 65, 200, 30);
        panel.add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Raleway", Font.BOLD, 20));
        label3.setBounds(290, 95, 300, 30);
        panel.add(label3);

        JLabel labelName = new JLabel("Name:");
        labelName.setFont(new Font("Raleway", Font.BOLD, 16));
        labelName.setBounds(100, 150, 100, 25);
        panel.add(labelName);

        textName = new JTextField();
        textName.setBounds(280, 150, 350, 25);
        panel.add(textName);

        JLabel labelfName = new JLabel("Father Name:");
        labelfName.setFont(new Font("Raleway", Font.BOLD, 16));
        labelfName.setBounds(100, 190, 150, 25);
        panel.add(labelfName);

        textFname = new JTextField();
        textFname.setBounds(280, 190, 350, 25);
        panel.add(textFname);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 230, 150, 25);
        panel.add(gender);

        r1 = new JRadioButton("Male");
        r1.setBounds(280, 230, 80, 25);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(380, 230, 100, 25);
        panel.add(r2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        JLabel dob = new JLabel("DOB:");
        dob.setBounds(100, 270, 150, 25);
        panel.add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(280, 270, 350, 25);
        panel.add(dateChooser);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 310, 150, 25);
        panel.add(email);

        textEmail = new JTextField();
        textEmail.setBounds(280, 310, 350, 25);
        panel.add(textEmail);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 350, 150, 25);
        panel.add(marital);

        m1 = new JRadioButton("Married");
        m1.setBounds(280, 350, 90, 25);
        panel.add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(380, 350, 120, 25);
        panel.add(m2);

        m3 = new JRadioButton("Other");
        m3.setBounds(520, 350, 100, 25);
        panel.add(m3);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(m1);
        bg2.add(m2);
        bg2.add(m3);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 390, 150, 25);
        panel.add(address);

        textAdd = new JTextField();
        textAdd.setBounds(280, 390, 350, 25);
        panel.add(textAdd);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 430, 150, 25);
        panel.add(city);

        textcity = new JTextField();
        textcity.setBounds(280, 430, 350, 25);
        panel.add(textcity);

        JLabel pin = new JLabel("Postal Code:");
        pin.setBounds(100, 470, 150, 25);
        panel.add(pin);

        textPin = new JTextField();
        textPin.setBounds(280, 470, 350, 25);
        panel.add(textPin);

        JLabel state = new JLabel("Province:");
        state.setBounds(100, 510, 150, 25);
        panel.add(state);

        textState = new JTextField();
        textState.setBounds(280, 510, 350, 25);
        panel.add(textState);

        next = new JButton("NEXT");
        next.setBounds(520, 580, 110, 35);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);

        setSize(700, 650);   // 🔥 SAME STYLE AS SIGNUP2
        setLocation(400, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == next) {

            String formno = first;
            String name = textName.getText();
            String fname = textFname.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

            String gender = r1.isSelected() ? "Male" : "Female";
            String email = textEmail.getText();

            String marital = m1.isSelected() ? "Married" :
                    m2.isSelected() ? "Unmarried" : "Other";

            String address = textAdd.getText();
            String city = textcity.getText();
            String pincode = textPin.getText();
            String state = textState.getText();

            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill required fields");
                } else {
                    Connn c = new Connn();

                    String q = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";

                    c.statement.executeUpdate(q);

                    new Bank.management.system.Signup2(formno);
                    setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

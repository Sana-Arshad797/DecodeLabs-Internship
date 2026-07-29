package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {

    JComboBox comboOccupation, comboIncome, comboEducation;
    JTextField textCnic;
    JRadioButton r1, r2, e1, e2;
    JButton next;

    String formno;

    Signup2(String formno) {

        super("APPLICATION FORM");
        this.formno = formno;

        setLayout(null);

        // LOGO
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel logo = new JLabel(new ImageIcon(i2));
        logo.setBounds(20, 10, 100, 100);
        add(logo);

        // TITLE
        JLabel title = new JLabel("Additional Details - Page 2");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(250, 40, 400, 30);
        add(title);

        JLabel form = new JLabel("Form No: " + formno);
        form.setBounds(600, 20, 200, 20);
        add(form);

        // INCOME
        JLabel income = new JLabel("Income Source");
        income.setBounds(100, 150, 150, 25);
        add(income);

        comboIncome = new JComboBox(new String[]{
                "No Income",
                "Salary",
                "Business",
                "Freelance",
                "Other"
        });
        comboIncome.setBounds(300, 150, 300, 25);
        add(comboIncome);

        // EDUCATION
        JLabel edu = new JLabel("Education");
        edu.setBounds(100, 200, 150, 25);
        add(edu);

        comboEducation = new JComboBox(new String[]{
                "Matric",
                "Intermediate",
                "Graduate",
                "Post Graduate",
                "Other"
        });
        comboEducation.setBounds(300, 200, 300, 25);
        add(comboEducation);

        // OCCUPATION
        JLabel occ = new JLabel("Occupation");
        occ.setBounds(100, 250, 150, 25);
        add(occ);

        comboOccupation = new JComboBox(new String[]{
                "Student",
                "Salaried",
                "Business Owner",
                "Self Employed",
                "Unemployed"
        });
        comboOccupation.setBounds(300, 250, 300, 25);
        add(comboOccupation);

        // CNIC
        JLabel cnic = new JLabel("CNIC Number");
        cnic.setBounds(100, 300, 150, 25);
        add(cnic);

        textCnic = new JTextField();
        textCnic.setBounds(300, 300, 300, 25);
        add(textCnic);

        // SENIOR CITIZEN
        JLabel senior = new JLabel("Senior Citizen");
        senior.setBounds(100, 350, 150, 25);
        add(senior);

        r1 = new JRadioButton("Yes");
        r1.setBounds(300, 350, 80, 25);
        add(r1);

        r2 = new JRadioButton("No");
        r2.setBounds(380, 350, 80, 25);
        add(r2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);

        // EXISTING ACCOUNT
        JLabel exist = new JLabel("Existing Bank Account");
        exist.setBounds(100, 400, 180, 25);
        add(exist);

        e1 = new JRadioButton("Yes");
        e1.setBounds(300, 400, 80, 25);
        add(e1);

        e2 = new JRadioButton("No");
        e2.setBounds(380, 400, 80, 25);
        add(e2);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(e1);
        bg2.add(e2);

        // NEXT BUTTON (BOTTOM RIGHT)
        next = new JButton("NEXT");
        next.setBounds(600, 500, 120, 35);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(new Color(183, 204, 241));

        setSize(800, 600);
        setLocation(400, 120);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String income = (String) comboIncome.getSelectedItem();
        String education = (String) comboEducation.getSelectedItem();
        String occupation = (String) comboOccupation.getSelectedItem();
        String cnic = textCnic.getText();

        String senior = r1.isSelected() ? "Yes" : "No";
        String existing = e1.isSelected() ? "Yes" : "No";

        try {
            if (cnic.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter CNIC Number");
            } else {

                Bank.management.system.Connn c = new Bank.management.system.Connn();

                String q = "insert into Signuptwo values('"
                        + formno + "','" + income + "','" + education + "','"
                        + occupation + "','" + cnic + "','" + senior + "','"
                        + existing + "')";

                c.statement.executeUpdate(q);

                new Bank.management.system.Signup3(formno);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}

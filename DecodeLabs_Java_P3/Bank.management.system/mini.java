package Bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    String pin;
    JButton button;

    // Constructor setup for Mini Statement UI context layout
    public mini(String pin) {
        this.pin = pin;
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        // Transaction history view field label
        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 250);
        add(label1);

        // Primary Header Title
        JLabel label2 = new JLabel("AL-YUSR Digital Banking System");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(80, 20, 250, 20); // Fixed bounds layout overlap alignment
        add(label2);

        // Card number string mask indicator layout label
        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 350, 20);
        add(label3);

        // Sum balance accumulation data label component
        JLabel label4 = new JLabel();
        label4.setBounds(20, 450, 300, 20);
        add(label4);

        // Fetch masked Card Number details from the authenticated database credentials
        try {
            Connn c = new Connn(); // Fixed: Changed from Connn to Conn
            // Fixed: Changed query to match your specific 'login' table parameters (pinnum and cardnum)
            ResultSet resultSet = c.statement.executeQuery("select * from login where pinnum = '" + pin + "'");
            while (resultSet.next()) {
                String card = resultSet.getString("cardnum");
                label3.setText("Card Number:  " + card.substring(0, 4) + "XXXXXXXX" + card.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Fetch transaction history pipeline tracking from updated metadata schema matching
        try {
            int balance = 0;
            Connn c = new Connn(); // Fixed: Changed from Connn to Conn

            // Fixed: Pull logs structural updates mapping cleanly from the core 'withdraw1' table reference
            ResultSet resultSet = c.statement.executeQuery("select * from withdraw1 where pin = '" + pin + "'");

            // StringBuilder wraps string appending inside loop smoothly without broken HTML layouts breaking up
            StringBuilder statementText = new StringBuilder("<html>");

            while (resultSet.next()) {
                statementText.append(resultSet.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(resultSet.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rs. ")
                        .append(resultSet.getString("amount"))
                        .append("<br><br>");

                // Calculate ongoing real-time updates balance context logic cleanly
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
            statementText.append("</html>");
            label1.setText(statementText.toString());

            label4.setText("Your Total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Frame destruction control operation click interface button
        button = new JButton("Exit");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    // Capture component close operations paths execution mapping
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false); // Clean termination path mapping closure framework
    }

    public static void main(String[] args) {
        new mini("");
    }
}

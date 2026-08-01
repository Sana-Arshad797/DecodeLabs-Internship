# AL-YUSR Digital Banking System

**Bank Management System with ATM Simulation using Java (GUI)**

A desktop banking application built in Java that simulates core banking operations — account registration, secure login, deposits, withdrawals, balance enquiry, mini statements, and PIN management — through a Java Swing GUI backed by a MySQL database.

| | |
|---|---|
| **Submitted by** | Sana Arshad |
| **Submitted to** | DecodeLabs |
| **Context** | DecodeLabs Remote Internship Task |

---

## Table of Contents

1. [Introduction](#1-introduction)
2. [Tools and Technologies Used](#2-tools-and-technologies-used)
3. [System Design](#3-system-design)
4. [System Modules](#4-system-modules)
5. [Key Code Snippets](#5-key-code-snippets)
6. [Testing](#6-testing)
7. [System Architecture](#7-system-architecture)
8. [Conclusion](#8-conclusion)

---

## 1. Introduction

### 1.1 Project Overview

AL-YUSR Digital Banking System is a desktop banking application built in Java. It simulates core banking operations such as account opening, login, deposits, withdrawals, balance enquiry, and PIN management. The application uses a graphical user interface built with Java Swing and stores data in a MySQL database.

### 1.2 Objectives

- Digitize basic banking operations through a simple, easy-to-use desktop interface.
- Allow new customers to open an account through an online application form.
- Allow existing customers to securely log in using a card number and PIN.
- Allow customers to deposit, withdraw, and check their account balance.
- Maintain a transaction history (mini statement) for every customer.

### 1.3 Scope

- Covers customer registration, authentication, and core teller operations: deposit, withdrawal, fast cash, balance enquiry, mini statement, and PIN change.
- Intended as an academic / demonstration project and is not connected to a real banking network.

---

## 2. Tools and Technologies Used

| Category | Technology |
|---|---|
| Programming Language | Java (JDK) |
| GUI Framework | Java Swing (`JFrame`, `JPanel`, `JLabel`, `JButton`, `JTextField`, `JPasswordField`) |
| Database | MySQL |
| Database Connectivity | JDBC (Java Database Connectivity) |
| Third-Party Library | JCalendar (`JDateChooser`) for date-of-birth selection |
| IDE | IntelliJ IDEA / Eclipse |

---

## 3. System Design

### 3.1 Database Tables

The system uses the following main tables in the MySQL database:

| Table | Purpose |
|---|---|
| `login` | Stores form number, card number, and PIN used for authentication. |
| `signupthree` | Stores form number, account type, card number, PIN, and facility/branch details for each registered customer. |
| `bank` | Stores every transaction as a record of PIN, date, transaction type (Deposit / Withdrawal), and amount. |

### 3.2 Application Flow

- **New User:** Sign Up (3-page form) → Card Number & PIN generated → Login.
- **Existing User:** Login → Main Dashboard → Deposit / Withdrawal / Fast Cash / Balance Enquiry / Mini Statement / Change PIN.

---

## 4. System Modules

### 4.1 Login Module

- Authenticates an existing customer using Card Number and PIN.
- Provides Sign In, Clear, and Sign Up buttons.
- On successful sign-in, redirects the user to the Main Dashboard.

![Login Module](screenshots/login.jpeg)

### 4.2 Sign Up Module

A 3-page application form used to register a new customer:

- **Page 1** — Personal details: Name, Father's Name, Date of Birth, Gender, and Marital Status.
- **Page 2** — Contact details: Email, Address, City, State, and Postal Code.
- **Page 3** — Account type selection; a unique Card Number and PIN are generated automatically, shown to the user, and saved to the database.

<p float="left">
  <img src="screenshots/signup-page1.jpeg" width="32%" alt="Sign Up Page 1" />
  <img src="screenshots/signup-page2.jpeg" width="32%" alt="Sign Up Page 2" />
  <img src="screenshots/signup-page3.jpeg" width="32%" alt="Sign Up Page 3" />
</p>

### 4.3 Main Dashboard

Central menu shown after a successful login. Provides navigation buttons to Deposit, Withdrawal, Fast Cash, Balance Enquiry, Mini Statement, and Change PIN.

### 4.4 Deposit Module

- Allows the customer to enter an amount and deposit it into their account.
- Inserts a new transaction record (PIN, date, type = Deposit, amount) into the `bank` table.
- Returns the customer to the Main Dashboard after a successful deposit.

![Deposit Module](screenshots/deposit.jpeg)

### 4.5 Withdrawal Module

- Allows the customer to withdraw an amount, up to a maximum limit of **Rs. 10,000**.
- Calculates the current balance from past transactions before approving a withdrawal.
- Rejects the request and shows an "Insufficient Balance" message if funds are not enough.
- Inserts a new transaction record (type = Withdrawal) into the `bank` table on success.

![Withdrawal Module](screenshots/withdrawal.jpeg)

### 4.6 Fast Cash Module

- Offers fixed quick-withdrawal amounts: **Rs. 100, 500, 1000, 2000, 5000, and 10000**.
- Performs the same balance check as the Withdrawal module before debiting the account.

### 4.7 Balance Enquiry Module

- Calculates and displays the customer's current balance.
- Balance is computed by summing all Deposit transactions and subtracting all Withdrawal transactions for the logged-in PIN.

![Balance Enquiry Module](screenshots/balance-enquiry.jpeg)

### 4.8 Mini Statement Module

- Displays a short transaction history for the logged-in customer: date, transaction type, and amount.
- Also displays the masked card number and the total current balance.

![Mini Statement Module](screenshots/mini-statement.jpeg)

### 4.9 PIN Management Module

- Allows the customer to set a new PIN by entering and re-confirming it.
- Validates that both entries match before updating the database.
- Updates the PIN consistently across the `bank`, `login`, and `signupthree` tables.

![PIN Management Module](screenshots/pin-management.jpeg)

---

## 5. Key Code Snippets

A few representative code snippets are included below. The complete source code is attached separately.

### 5.1 Database Connection (`Connn.java`)

```java
public class Connn {

    Connection connection;
    Statement statement;

    public Connn() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankSystem", "root", "password");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 5.2 Withdrawal Logic with Balance Check (`Withdrawl.java`)

```java
Connn c = new Connn();
ResultSet resultSet = c.statement.executeQuery(
    "select * from bank where pin = '" + pin + "'");

int balance = 0;
while (resultSet.next()) {
    if (resultSet.getString("type").equals("Deposit")) {
        balance += Integer.parseInt(resultSet.getString("amount"));
    } else {
        balance -= Integer.parseInt(resultSet.getString("amount"));
    }
}

if (balance < Integer.parseInt(amount)) {
    JOptionPane.showMessageDialog(null, "Insufficient Balance");
    return;
}

c.statement.executeUpdate("insert into bank values('" + pin + "', '" +
    date + "', 'Withdrawl', '" + amount + "')");
```

### 5.3 PIN Update Across Tables (`Pin.java`)

```java
String q1 = "update bank set pin = '" + pin1 + "' where pin = '" + pin + "'";
String q2 = "update login set pin = '" + pin1 + "' where pin = '" + pin + "'";
String q3 = "update signupthree set pin = '" + pin1 + "' where pin = '" + pin + "'";

c.statement.executeUpdate(q1);
c.statement.executeUpdate(q2);
c.statement.executeUpdate(q3);
```

> **Note:** The snippets above build SQL statements via string concatenation, which is vulnerable to SQL injection. For production use, replace these with `PreparedStatement` and parameterized queries.

---

## 6. Testing

- Verified that login fails for an incorrect Card Number / PIN combination.
- Verified that withdrawal and Fast Cash requests are blocked when the balance is insufficient.
- Verified that deposit and withdrawal amounts are correctly reflected in the Balance Enquiry and Mini Statement modules.
- Verified that a changed PIN is required for the next login and the old PIN no longer works.

---

## 7. System Architecture

![System Architecture](screenshots/system-architecture.jpeg)

---

## 8. Conclusion

- The AL-YUSR Digital Banking System successfully implements the core features of a desktop banking application: registration, authentication, deposits, withdrawals, balance enquiry, and PIN management.
- The project provided practical experience with Java Swing GUI design and JDBC-based database connectivity.
- All planned objectives for the project were achieved.

---

## License

This project was developed as part of the DecodeLabs Remote Internship program and is intended for academic and demonstration purposes only.

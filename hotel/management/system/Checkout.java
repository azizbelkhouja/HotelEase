package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Checkout extends JFrame {
    private JPanel contentPane;
    private JTextField t1;
    private Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Checkout frame = new Checkout();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Checkout() {
        // Frame setup
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 294);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Label: Check Out
        JLabel lblCheckOut = new JLabel("Check Out");
        lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCheckOut.setBounds(70, 11, 140, 35);
        contentPane.add(lblCheckOut);

        // Label: Number
        JLabel lblName = new JLabel("Number:");
        lblName.setBounds(20, 85, 80, 14);
        contentPane.add(lblName);

        // Choice: Customer numbers
        c1 = new Choice();
        populateCustomerNumbers();
        c1.setBounds(130, 82, 150, 20);
        contentPane.add(c1);

        // TextField: Room Number
        JLabel lblRoomNumber = new JLabel("Room Number:");
        lblRoomNumber.setBounds(20, 132, 100, 20);
        contentPane.add(lblRoomNumber);

        t1 = new JTextField();
        t1.setBounds(130, 132, 150, 20);
        contentPane.add(t1);

        // Button: Retrieve Room Number
        JButton retrieveButton = new JButton("Retrieve");
        retrieveButton.setBounds(290, 82, 100, 25);
        retrieveButton.addActionListener(this::retrieveRoomNumber);
        contentPane.add(retrieveButton);

        // Button: Check Out
        JButton btnCheckOut = new JButton("Check Out");
        btnCheckOut.setBounds(50, 200, 100, 25);
        btnCheckOut.setBackground(Color.BLACK);
        btnCheckOut.setForeground(Color.WHITE);
        btnCheckOut.addActionListener(this::checkOutCustomer);
        contentPane.add(btnCheckOut);

        // Button: Back
        JButton btnExit = new JButton("Back");
        btnExit.setBounds(160, 200, 100, 25);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        btnExit.addActionListener(e -> {
            new Reception().setVisible(true);
            setVisible(false);
        });
        contentPane.add(btnExit);

        // Set background color
        contentPane.setBackground(Color.WHITE);
    }

    // Populate customer numbers in Choice component
    private void populateCustomerNumbers() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT number FROM customer");
            while (rs.next()) {
                c1.add(rs.getString("number"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve room number for the selected customer
    private void retrieveRoomNumber(ActionEvent ae) {
        String number = c1.getSelectedItem();
        try {
            Conn c = new Conn();
            PreparedStatement pst = c.conn.prepareStatement("SELECT room FROM customer WHERE number = ?");
            pst.setString(1, number);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                t1.setText(rs.getString("room"));
            } else {
                JOptionPane.showMessageDialog(null, "Customer not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving room number.");
        }
    }

    // Perform checkout operation
    private void checkOutCustomer(ActionEvent e) {
        String id = c1.getSelectedItem();
        String roomNumber = t1.getText();
        String deleteSQL = "DELETE FROM customer WHERE number = ?";
        String updateSQL = "UPDATE room SET availability = 'Available' WHERE roomnumber = ?";

        try {
            Conn c = new Conn();
            PreparedStatement deleteStmt = c.conn.prepareStatement(deleteSQL);
            deleteStmt.setString(1, id);
            deleteStmt.executeUpdate();

            PreparedStatement updateStmt = c.conn.prepareStatement(updateSQL);
            updateStmt.setString(1, roomNumber);
            updateStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Check Out Successful");
            new Reception().setVisible(true);
            setVisible(false);

        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Check Out Failed");
        }
    }
}

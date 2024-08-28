package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {

    private Choice choiceCustomer;
    private JLabel lblRoomNumber, lblCheckInTime, lblCheckOutTime;
    private JButton btnCheck, btnBack;

    public Checkout() {
        setTitle("Checkout");
        setBounds(300, 200, 800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel lblTitle = new JLabel("Checkout");
        lblTitle.setBounds(100, 20, 200, 30);
        lblTitle.setForeground(new Color(25, 25, 112));
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(lblTitle);

        // Customer ID
        JLabel lblCustomerId = new JLabel("Customer ID:");
        lblCustomerId.setBounds(30, 80, 100, 25);
        lblCustomerId.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCustomerId.setForeground(new Color(25, 25, 112));
        add(lblCustomerId);

        choiceCustomer = new Choice();
        choiceCustomer.setBounds(150, 80, 150, 25);
        add(choiceCustomer);

        // Room Number
        JLabel lblRoom = new JLabel("Room Number:");
        lblRoom.setBounds(30, 130, 100, 25);
        lblRoom.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblRoom.setForeground(new Color(25, 25, 112));
        add(lblRoom);

        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(150, 130, 150, 25);
        lblRoomNumber.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblRoomNumber.setForeground(new Color(25, 25, 112));
        add(lblRoomNumber);

        // Check-In Time
        JLabel lblCheckIn = new JLabel("Check-In Time:");
        lblCheckIn.setBounds(30, 180, 100, 25);
        lblCheckIn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCheckIn.setForeground(new Color(25, 25, 112));
        add(lblCheckIn);

        lblCheckInTime = new JLabel();
        lblCheckInTime.setBounds(150, 180, 150, 25);
        lblCheckInTime.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCheckInTime.setForeground(new Color(25, 25, 112));
        add(lblCheckInTime);

        // Check-Out Time
        JLabel lblCheckOut = new JLabel("Check-Out Time:");
        lblCheckOut.setBounds(30, 230, 120, 25);
        lblCheckOut.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCheckOut.setForeground(new Color(25, 25, 112));
        add(lblCheckOut);

        lblCheckOutTime = new JLabel(new Date().toString());
        lblCheckOutTime.setBounds(150, 230, 200, 25);
        lblCheckOutTime.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblCheckOutTime.setForeground(new Color(25, 25, 112));
        add(lblCheckOutTime);

        // Check Button
        btnCheck = createStyledButton("Check", 30, 280);

        // Back Button
        btnBack = createStyledButton("Back", 170, 280);

        // Background Image
        JLabel imageLabel = createImageLabel("icons/sixth.jpg", 350, 50, 400, 250);
        add(imageLabel);

        // Load Customer Data
        loadCustomerData();

        setVisible(true);
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 35);
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
            }
        });

        button.addActionListener(this);
        add(button);
        return button;
    }

    private JLabel createImageLabel(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(img));
        label.setBounds(x, y, width, height);
        return label;
    }

    private void loadCustomerData() {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                choiceCustomer.add(rs.getString("number"));
                lblRoomNumber.setText(rs.getString("room"));
                lblCheckInTime.setText(rs.getString("checkintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCheck) {
            String selectedCustomerId = choiceCustomer.getSelectedItem();
            String roomNumber = lblRoomNumber.getText();

            String deleteCustomerQuery = "DELETE FROM customer WHERE number = '" + selectedCustomerId + "'";
            String updateRoomQuery = "UPDATE room SET availability = 'Available' WHERE roomnumber = '" + roomNumber + "'";

            try {
                Conn conn = new Conn();
                conn.s.executeUpdate(deleteCustomerQuery);
                conn.s.executeUpdate(updateRoomQuery);

                JOptionPane.showMessageDialog(null, "Checkout completed successfully");
                setVisible(false);
                new Reception(); // Assuming Reception is the previous window
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            new Reception(); // Assuming Reception is the previous window
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Checkout();
    }
}

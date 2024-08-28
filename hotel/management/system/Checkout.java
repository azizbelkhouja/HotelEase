package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {

    private Choice ccustomer;
    private JLabel lblRoomNumber, lblCheckinTime, lblCheckoutTime;
    private JButton btnCheck, btnBack;

    public Checkout() {
        // Frame settings
        setTitle("Checkout");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title Label
        JLabel lblTitle = createLabel("Checkout", 100, 20, 100, 30, new Font("Tahoma", Font.PLAIN, 20), Color.BLUE);
        add(lblTitle);

        // Customer ID Label and Choice
        JLabel lblCustomerId = createLabel("Customer Id:", 30, 80, 100, 20);
        add(lblCustomerId);

        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 100, 30);
        populateCustomerChoice();
        add(ccustomer);

        // Customer Tick Image
        JLabel lblTick = createImageLabel("icons/tick.png", 255, 80, 20, 20);
        add(lblTick);

        // Room Number Label
        JLabel lblRoom = createLabel("Room Number:", 30, 130, 100, 30);
        add(lblRoom);
        lblRoomNumber = createLabel("", 150, 130, 100, 30);
        add(lblRoomNumber);

        // Check-In Time Label
        JLabel lblCheckin = createLabel("Check in:", 30, 180, 100, 30);
        add(lblCheckin);
        lblCheckinTime = createLabel("", 150, 180, 100, 30);
        add(lblCheckinTime);

        // Check-Out Time Label
        JLabel lblCheckout = createLabel("Check out:", 30, 230, 100, 30);
        add(lblCheckout);
        Date date = new Date();
        lblCheckoutTime = createLabel(date.toString(), 150, 230, 150, 30);
        add(lblCheckoutTime);

        // Buttons
        btnCheck = createButton("Check", 30, 280, 120, 30);
        btnCheck.addActionListener(this);
        add(btnCheck);

        btnBack = createButton("Back", 170, 280, 120, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        // Image Label
        JLabel lblImage = createImageLabel("icons/sixth.jpg", 350, 50, 400, 250);
        add(lblImage);

        // Frame settings
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height) {
        return createLabel(text, x, y, width, height, new Font("Tahoma", Font.PLAIN, 14), Color.BLACK);
    }

    private JLabel createLabel(String text, int x, int y, int width, int height, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(font);
        label.setForeground(color);
        return label;
    }

    private JLabel createImageLabel(String imagePath, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(imagePath));
        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new JLabel(new ImageIcon(img));
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(Color.BLACK);
            }
        });

        return button;
    }

    private void populateCustomerChoice() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
            if (rs.first()) {
                lblRoomNumber.setText(rs.getString("room"));
                lblCheckinTime.setText(rs.getString("checkintime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCheck) {
            checkOut();
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            new Reception();
        }
    }

    private void checkOut() {
        String customerId = ccustomer.getSelectedItem();
        String roomNumber = lblRoomNumber.getText();
        if (customerId.isEmpty() || roomNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No customer selected", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Conn c = new Conn();
            String query1 = "DELETE FROM customer WHERE number = '" + customerId + "'";
            String query2 = "UPDATE room SET availability = 'Available' WHERE roomnumber = '" + roomNumber + "'";

            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);

            JOptionPane.showMessageDialog(this, "Checkout done successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            new Reception();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during checkout", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Checkout::new);
    }
}

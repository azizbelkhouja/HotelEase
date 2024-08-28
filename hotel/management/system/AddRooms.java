package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class AddRooms extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfRoomNumber, tfPrice;
    private JComboBox<String> cbAvailability, cbCleaningStatus, cbBedType;
    private JButton btnAdd, btnBack;

    public AddRooms() {
        setTitle("Add Room");
        setBounds(350, 200, 900, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Add Room Details");
        lblTitle.setBounds(30, 20, 300, 30);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(lblTitle);

        // Room Number
        JLabel lblRoomNumber = createLabel("Room Number:", 60, 80);
        tfRoomNumber = createModernTextField(200, 80);

        // Availability
        JLabel lblAvailability = createLabel("Availability:", 60, 130);
        cbAvailability = createComboBox(new String[] { "Available", "Occupied" }, 200, 130);

        // Cleaning Status
        JLabel lblCleaningStatus = createLabel("Cleaning Status:", 60, 180);
        cbCleaningStatus = createComboBox(new String[] { "Cleaned", "Dirty" }, 200, 180);

        // Price
        JLabel lblPrice = createLabel("Price:", 60, 230);
        tfPrice = createModernTextField(200, 230);

        // Bed Type
        JLabel lblBedType = createLabel("Bed Type:", 60, 280);
        cbBedType = createComboBox(new String[] { "Single Bed", "Double Bed" }, 200, 280);

        // Add Button
        btnAdd = createStyledButton("Add", 60, 340);
        btnAdd.addActionListener(this);

        // Back Button
        btnBack = createStyledButton("Back", 200, 340);
        btnBack.addActionListener(this);

        // Image
        JLabel imageLabel = createImageLabel("icons/twelve.jpg", 450, 50, 400, 350);
        add(imageLabel);

        // Background color
        contentPane.setBackground(Color.WHITE);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
        label.setForeground(new Color(25, 25, 112));
        add(label);
        return label;
    }

    private JTextField createModernTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 200, 30);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(192, 192, 192)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        add(textField);
        return textField;
    }

    private JComboBox<String> createComboBox(String[] options, int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, 200, 30);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(192, 192, 192)));
        add(comboBox);
        return comboBox;
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 40);
        button.setFont(new Font("SansSerif", Font.PLAIN, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        button.setOpaque(true);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237));
                button.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
                button.setForeground(Color.WHITE);
            }
        });

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

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAdd) {
            try {
                Conn conn = new Conn();
                String roomNumber = tfRoomNumber.getText();
                String availability = (String) cbAvailability.getSelectedItem();
                String cleaningStatus = (String) cbCleaningStatus.getSelectedItem();
                String price = tfPrice.getText();
                String bedType = (String) cbBedType.getSelectedItem();

                // Basic validation
                if (roomNumber.isEmpty() || price.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields");
                    return;
                }

                String query = "INSERT INTO room (room_number, availability, cleaning_status, price, bed_type) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.getConnection().prepareStatement(query);
                ps.setString(1, roomNumber);
                ps.setString(2, availability);
                ps.setString(3, cleaningStatus);
                ps.setString(4, price);
                ps.setString(5, bedType);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Room Successfully Added");
                setVisible(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            // Go back to the previous screen, if applicable
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AddRooms();
    }
}

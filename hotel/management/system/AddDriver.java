package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {

    private JTextField tfName, tfAge, tfCompany, tfBrand, tfLocation;
    private JComboBox<String> comboGender, comboAvailable;
    private JButton addButton, backButton;

    public AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("ADD DRIVER");
        title.setBounds(150, 20, 400, 40);
        title.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(title);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(50, 80, 150, 30);
        lblName.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblName);

        tfName = createModernTextField();
        tfName.setBounds(200, 80, 200, 30);
        add(tfName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(50, 130, 150, 30);
        lblAge.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblAge);

        tfAge = createModernTextField();
        tfAge.setBounds(200, 130, 200, 30);
        add(tfAge);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(50, 180, 150, 30);
        lblGender.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblGender);

        comboGender = new JComboBox<>(new String[]{"Male", "Female"});
        comboGender.setBounds(200, 180, 200, 30);
        comboGender.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboGender.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(comboGender);

        JLabel lblCompany = new JLabel("Car Company:");
        lblCompany.setBounds(50, 230, 150, 30);
        lblCompany.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblCompany);

        tfCompany = createModernTextField();
        tfCompany.setBounds(200, 230, 200, 30);
        add(tfCompany);

        JLabel lblBrand = new JLabel("Car Brand:");
        lblBrand.setBounds(50, 280, 150, 30);
        lblBrand.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblBrand);

        tfBrand = createModernTextField();
        tfBrand.setBounds(200, 280, 200, 30);
        add(tfBrand);

        JLabel lblAvailable = new JLabel("Available:");
        lblAvailable.setBounds(50, 330, 150, 30);
        lblAvailable.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblAvailable);

        comboAvailable = new JComboBox<>(new String[]{"Yes", "No"});
        comboAvailable.setBounds(200, 330, 200, 30);
        comboAvailable.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboAvailable.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(comboAvailable);

        JLabel lblLocation = new JLabel("Location:");
        lblLocation.setBounds(50, 380, 150, 30);
        lblLocation.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblLocation);

        tfLocation = createModernTextField();
        tfLocation.setBounds(200, 380, 200, 30);
        add(tfLocation);

        addButton = createStyledButton("Add");
        addButton.setBounds(50, 430, 150, 40);
        add(addButton);

        backButton = createStyledButton("Back");
        backButton.setBounds(250, 430, 150, 40);
        add(backButton);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(450, 80, 300, 400);
        add(image);

        setBounds(350, 200, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JTextField createModernTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(192, 192, 192)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return textField;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        button.setOpaque(true);
        button.setBackground(new Color(70, 130, 180));
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());

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

        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            try {
                Conn conn = new Conn();
                String name = tfName.getText();
                String age = tfAge.getText();
                String gender = (String) comboGender.getSelectedItem();
                String company = tfCompany.getText();
                String brand = tfBrand.getText();
                String available = (String) comboAvailable.getSelectedItem();
                String location = tfLocation.getText();

                String query = "INSERT INTO driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver Successfully Added");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AddDriver();
    }
}

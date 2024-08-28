package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AddDriver extends JFrame implements ActionListener {

    private JTextField t1, t2, t3, t4, t5;
    private JComboBox<String> genderBox, availableBox;
    private JButton addButton, backButton;

    public AddDriver() {
        setTitle("Add Driver");
        setBounds(450, 200, 900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel title = new JLabel("Add Drivers");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setBounds(150, 20, 200, 30);
        add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        nameLabel.setBounds(60, 80, 150, 30);
        add(nameLabel);

        t1 = new JTextField();
        t1.setFont(new Font("SansSerif", Font.PLAIN, 16));
        t1.setBounds(180, 80, 200, 30);
        add(t1);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        ageLabel.setBounds(60, 130, 150, 30);
        add(ageLabel);

        t2 = new JTextField();
        t2.setFont(new Font("SansSerif", Font.PLAIN, 16));
        t2.setBounds(180, 130, 200, 30);
        add(t2);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        genderLabel.setBounds(60, 180, 150, 30);
        add(genderLabel);

        genderBox = new JComboBox<>(new String[]{"Male", "Female"});
        genderBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        genderBox.setBounds(180, 180, 200, 30);
        add(genderBox);

        JLabel companyLabel = new JLabel("Car Company:");
        companyLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        companyLabel.setBounds(60, 230, 150, 30);
        add(companyLabel);

        t3 = new JTextField();
        t3.setFont(new Font("SansSerif", Font.PLAIN, 16));
        t3.setBounds(180, 230, 200, 30);
        add(t3);

        JLabel brandLabel = new JLabel("Car Brand:");
        brandLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        brandLabel.setBounds(60, 280, 150, 30);
        add(brandLabel);

        t4 = new JTextField();
        t4.setFont(new Font("SansSerif", Font.PLAIN, 16));
        t4.setBounds(180, 280, 200, 30);
        add(t4);

        JLabel availableLabel = new JLabel("Available:");
        availableLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        availableLabel.setBounds(60, 330, 150, 30);
        add(availableLabel);

        availableBox = new JComboBox<>(new String[]{"Yes", "No"});
        availableBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        availableBox.setBounds(180, 330, 200, 30);
        add(availableBox);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
        locationLabel.setBounds(60, 380, 150, 30);
        add(locationLabel);

        t5 = new JTextField();
        t5.setFont(new Font("SansSerif", Font.PLAIN, 16));
        t5.setBounds(180, 380, 200, 30);
        add(t5);

        addButton = createStyledButton("Add");
        addButton.setBounds(60, 430, 150, 40);
        add(addButton);

        backButton = createStyledButton("Back");
        backButton.setBounds(230, 430, 150, 40);
        add(backButton);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image img = icon.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        imageLabel.setBounds(450, 100, 400, 300);
        add(imageLabel);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(70, 130, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(100, 149, 237));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(70, 130, 180));
            }
        });

        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addButton) {
            try {
                Conn c = new Conn();
                String name = t1.getText();
                String age = t2.getText();
                String gender = (String) genderBox.getSelectedItem();
                String company = t3.getText();
                String brand = t4.getText();
                String available = (String) availableBox.getSelectedItem();
                String location = t5.getText();

                String query = "INSERT INTO driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + brand + "','" + available + "','" + location + "')";
                c.s.executeUpdate(query);

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

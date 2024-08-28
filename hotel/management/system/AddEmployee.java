package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    private JTextField tfName, tfAge, tfPhone, tfEmail, tfSalary, tfCf;
    private JRadioButton rbMale, rbFemale;
    private JButton btnSubmit, btnBack;
    private JComboBox<String> cbJob;

    public AddEmployee() {
        setTitle("Add Employee");
        setBounds(350, 200, 850, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("ADD EMPLOYEE DETAILS");
        lblTitle.setBounds(250, 20, 400, 40);
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(lblTitle);

        // Name
        JLabel lblName = createLabel("Name:", 60, 100);
        tfName = createModernTextField(200, 100);

        // Age
        JLabel lblAge = createLabel("Age:", 60, 150);
        tfAge = createModernTextField(200, 150);

        // Gender
        JLabel lblGender = createLabel("Gender:", 60, 200);
        rbMale = createModernRadioButton("Male", 200, 200);
        rbFemale = createModernRadioButton("Female", 280, 200);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        // Job
        JLabel lblJob = createLabel("Job:", 60, 250);
        String[] jobs = {"Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cbJob = createComboBox(jobs, 200, 250);

        // Salary
        JLabel lblSalary = createLabel("Salary:", 60, 300);
        tfSalary = createModernTextField(200, 300);

        // Phone
        JLabel lblPhone = createLabel("Phone:", 60, 350);
        tfPhone = createModernTextField(200, 350);

        // Email
        JLabel lblEmail = createLabel("Email:", 60, 400);
        tfEmail = createModernTextField(200, 400);

        // Fiscal Code
        JLabel lblCf = createLabel("Fiscal Code:", 60, 450);
        tfCf = createModernTextField(200, 450);

        // Submit Button
        btnSubmit = createStyledButton("Submit", 450, 450);
        btnSubmit.addActionListener(this);

        // Back Button
        btnBack = createStyledButton("Back", 650, 450);
        btnBack.addActionListener(this);

        // Image
        JLabel image = createImageLabel("icons/tenth.jpg", 450, 100, 350, 300);
        add(image);

        // Background color
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18));
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

    private JRadioButton createModernRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 100, 30);
        radioButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        radioButton.setBackground(Color.WHITE);
        radioButton.setFocusPainted(false);
        add(radioButton);
        return radioButton;
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
        button.setBounds(x, y, 150, 40);
        button.setFont(new Font("SansSerif", Font.PLAIN, 18));
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSubmit) {
            String name = tfName.getText();
            String age = tfAge.getText();
            String salary = tfSalary.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            String cf = tfCf.getText();

            String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : null;
            String job = (String) cbJob.getSelectedItem();

            // Basic validation
            if (name.isEmpty() || age.isEmpty() || salary.isEmpty() || phone.isEmpty() || email.isEmpty() || cf.isEmpty() || gender == null || job.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
                return;
            }

            try {
                Conn conn = new Conn();
                String query = "INSERT INTO employee (name, age, gender, job, salary, phone, email, cf) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.getConnection().prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, age);
                ps.setString(3, gender);
                ps.setString(4, job);
                ps.setString(5, salary);
                ps.setString(6, phone);
                ps.setString(7, email);
                ps.setString(8, cf);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Employee Added");
                setVisible(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == btnBack) {
            setVisible(false);
            
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AddEmployee();
    }
}

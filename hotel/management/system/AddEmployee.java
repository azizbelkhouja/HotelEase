package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener {

    private JTextField tfName, tfAge, tfPhone, tfEmail, tfSalary, tfCf;
    private JRadioButton rbMale, rbFemale;
    private JButton btnSubmit;
    private JComboBox<String> cbJob;

    public AddEmployee() {
        setTitle("Add Employee");
        setBounds(350, 200, 850, 540);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        // Name
        JLabel lblName = createLabel("Name:", 60, 30);
        tfName = createTextField(200, 30);

        // Age
        JLabel lblAge = createLabel("Age:", 60, 80);
        tfAge = createTextField(200, 80);

        // Gender
        JLabel lblGender = createLabel("Gender:", 60, 130);
        rbMale = createRadioButton("Male", 200, 130);
        rbFemale = createRadioButton("Female", 280, 130);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        // Job
        JLabel lblJob = createLabel("Job:", 60, 180);
        String[] jobs = {"Front Desk Clerk", "Porter", "Housekeeping", "Kitchen Staff", "Room Service", "Waiter/Waitress", "Manager", "Accountant", "Chef"};
        cbJob = createComboBox(jobs, 200, 180);

        // Salary
        JLabel lblSalary = createLabel("Salary:", 60, 230);
        tfSalary = createTextField(200, 230);

        // Phone
        JLabel lblPhone = createLabel("Phone:", 60, 280);
        tfPhone = createTextField(200, 280);

        // Email
        JLabel lblEmail = createLabel("Email:", 60, 330);
        tfEmail = createTextField(200, 330);

        // Fiscal Code
        JLabel lblCf = createLabel("Fiscal Code:", 60, 380);
        tfCf = createTextField(200, 380);

        // Submit Button
        btnSubmit = createButton("Submit", 200, 430);
        btnSubmit.addActionListener(this);

        // Image
        JLabel image = createImageLabel("icons/tenth.jpg", 380, 60, 450, 370);
        add(image);

        // Background color
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        label.setFont(new Font("SansSerif", Font.PLAIN, 17));
        add(label);
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 150, 30);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(textField);
        return textField;
    }

    private JRadioButton createRadioButton(String text, int x, int y) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setBounds(x, y, 70, 30);
        radioButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        radioButton.setBackground(Color.WHITE);
        add(radioButton);
        return radioButton;
    }

    private JComboBox<String> createComboBox(String[] options, int x, int y) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, 150, 30);
        comboBox.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboBox.setBackground(Color.WHITE);
        add(comboBox);
        return comboBox;
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 40);
        button.setFont(new Font("SansSerif", Font.PLAIN, 20));
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

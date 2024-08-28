package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {

    JComboBox<String> comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;

    AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(150, 20, 400, 40);
        text.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(text);

        JLabel lblid = new JLabel("ID:");
        lblid.setBounds(50, 80, 150, 30);
        lblid.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblid);

        String[] options = {"FISCAL CODE", "Passport", "Driving Licence"};
        comboid = new JComboBox<>(options);
        comboid.setBounds(200, 80, 200, 30);
        comboid.setFont(new Font("SansSerif", Font.PLAIN, 16));
        comboid.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(comboid);

        JLabel lblnumber = new JLabel("Number:");
        lblnumber.setBounds(50, 130, 150, 30);
        lblnumber.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblnumber);
        tfnumber = createModernTextField();
        tfnumber.setBounds(200, 130, 200, 30);
        add(tfnumber);

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 180, 150, 30);
        lblname.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblname);
        tfname = createModernTextField();
        tfname.setBounds(200, 180, 200, 30);
        add(tfname);

        JLabel lblgender = new JLabel("Gender:");
        lblgender.setBounds(50, 230, 150, 30);
        lblgender.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblgender);
        rbmale = createModernRadioButton("Male");
        rbmale.setBounds(200, 230, 80, 30);
        add(rbmale);
        rbfemale = createModernRadioButton("Female");
        rbfemale.setBounds(290, 230, 100, 30);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblcountry = new JLabel("Country:");
        lblcountry.setBounds(50, 280, 150, 30);
        lblcountry.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblcountry);
        tfcountry = createModernTextField();
        tfcountry.setBounds(200, 280, 200, 30);
        add(tfcountry);

        JLabel lblroom = new JLabel("Room:");
        lblroom.setBounds(50, 330, 150, 30);
        lblroom.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lblroom);
        croom = new Choice();
        try {
            Conn conn = new Conn();
            String query = "select * from room";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        croom.setBounds(200, 330, 200, 30);
        add(croom);

        JLabel lbltime = new JLabel("Check-In:");
        lbltime.setBounds(50, 380, 150, 30);
        lbltime.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lbltime);
        Date date = new Date();
        checkintime = new JLabel(date.toString());
        checkintime.setBounds(200, 380, 200, 30);
        checkintime.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(checkintime);

        JLabel lbldeposit = new JLabel("Deposit:");
        lbldeposit.setBounds(50, 430, 150, 30);
        lbldeposit.setFont(new Font("SansSerif", Font.PLAIN, 18));
        add(lbldeposit);
        tfdeposit = createModernTextField();
        tfdeposit.setBounds(200, 430, 200, 30);
        add(tfdeposit);

        add = createStyledButton("Add");
        add.setBounds(50, 480, 150, 40);
        add(add);

        back = createStyledButton("Back");
        back.setBounds(250, 480, 150, 40);
        add(back);

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

    private JRadioButton createModernRadioButton(String text) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        radioButton.setBackground(Color.WHITE);
        radioButton.setFocusPainted(false);
        return radioButton;
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
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = rbmale.isSelected() ? "Male" : "Female";
            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tfdeposit.getText();

            try {
                String query1 = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
                String query2 = "update room set availability = 'Occupied' where roomnumber = '" + room + "'";

                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                setVisible(false);
                new Reception();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new AddCustomer();
    }
}

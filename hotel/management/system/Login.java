package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField username;
    JPasswordField password;  // Changed to JPasswordField
    JButton login, cancel;
    
    Login() {
        getContentPane().setBackground(Color.BLACK);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username: ");
        user.setBounds(40, 20, 100, 30);
        user.setForeground(Color.WHITE);
        add(user);
        
        username = new JTextField();
        username.setBounds(150, 20, 150, 30);
        add(username);
        
        JLabel pass = new JLabel("Password: ");
        pass.setBounds(40, 70, 100, 30);
        pass.setForeground(Color.WHITE);
        add(pass);
        
        password = new JPasswordField();  // Changed to JPasswordField
        password.setBounds(150, 70, 150, 30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.setBackground(Color.WHITE);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("serif", Font.PLAIN, 24));
        login.addActionListener(this);  // Corrected action listener for login
        add(login);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("serif", Font.PLAIN, 24));
        cancel.addActionListener(this);  // Corrected action listener for cancel
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 200, 200);
        add(image);
        
        setBounds(500, 200, 600, 300);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = String.valueOf(password.getPassword());  // Changed to handle JPasswordField
            
            try {
                Conn c = new Conn();
                
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()) {
                    setVisible(false);
                    new Dashboard();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                    username.setText("");  // Clear fields on invalid input
                    password.setText("");
                }
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

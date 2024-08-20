package hotel.management.system;

import java.awt.*;
import javax. swing.*;

public class Login extends JFrame {
    
    Login() {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("Username");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
        JLabel pass = new JLabel("Username");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
        setBounds(500, 200, 600, 300);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

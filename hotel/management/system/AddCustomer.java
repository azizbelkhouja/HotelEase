package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {
    AddCustomer() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100, 20, 300, 30);
        add(text);
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    
    
    
    public static void main(String[] args) {
        new AddCustomer();
    }
}

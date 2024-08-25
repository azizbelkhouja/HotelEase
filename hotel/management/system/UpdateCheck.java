package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UpdateCheck extends JFrame {
    
    Choice ccustomer;
    
    UpdateCheck() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahome", Font.PLAIN, 20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        
        
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new UpdateCheck();
    }
}

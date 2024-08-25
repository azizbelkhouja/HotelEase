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
        
        JLabel lblid = new JLabel("Customer Id: ");
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
        
        JLabel lblroom = new JLabel("Room Number: ");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);
        JTextField tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 25);
        add(tfroom);
        
        JLabel lblname = new JLabel("Name: ");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);
        JTextField tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 25);
        add(tfname);
        
        JLabel lblcheckin = new JLabel("Checkin Time: ");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);
        JTextField tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 150, 25);
        add(tfcheckin);
        
        JLabel lblpaid = new JLabel("Amount Paid: ");
        lblpaid.setBounds(30, 240, 100, 20);
        add(lblpaid);
        JTextField tfpaid = new JTextField();
        tfpaid.setBounds(200, 240, 150, 25);
        add(tfpaid);
        
        
        
        
        setBounds(300, 200, 980, 500);
        setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        new UpdateCheck();
    }
}

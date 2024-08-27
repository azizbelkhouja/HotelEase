package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    
    Choice ccustomer;
    JLabel lblroomnumber, lblcheckintime, lblcheckoutime;
    JButton check, back;
    
    Checkout() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100, 20, 100, 30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahome", Font.PLAIN, 20));
        add(text);
        
        JLabel lblid = new JLabel("Customer Id: ");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        ccustomer = new Choice();
        ccustomer.setBounds(150, 80, 100, 30);
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(255, 80, 20, 20);
        add(image);
        
        JLabel lblroom = new JLabel("Room Number: ");
        lblroom.setBounds(30, 130, 100, 30);
        add(lblroom);
        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 130, 100, 30);
        add(lblroomnumber);
        
        JLabel lblcheckin = new JLabel("Check in: ");
        lblcheckin.setBounds(30, 180, 100, 30);
        add(lblcheckin);
        lblcheckintime = new JLabel();
        lblcheckintime.setBounds(150, 180, 100, 30);
        add(lblcheckintime);
        
        JLabel lblcheckout = new JLabel("Check out: ");
        lblcheckout.setBounds(30, 230, 100, 30);
        add(lblcheckout);
        Date date = new Date();
        lblcheckoutime = new JLabel("" + date);
        lblcheckoutime.setBounds(150, 230, 150, 30);
        add(lblcheckoutime);
        
        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30, 280, 120, 30);
        check.addActionListener(this);
        add(check);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170, 280, 120, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(350, 50, 400, 250);
        add(image2);
        
        setBounds(300, 200, 800, 400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String query1 = "delete from customer where number = '"+ccustomer+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomnumber.getText()+"'";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout done successfully");
                setVisible(false);
                new Reception();
                
            } catch (Exception e) {
                e.getStackTrace();
            }
        } else {
                setVisible(false);
                new Reception();
          }
    }
    
    public static void main(String[] args) {
        new Checkout();
    }
    
}
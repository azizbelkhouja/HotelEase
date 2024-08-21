package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame {
    
    Dashboard() {
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1550, 1000);
        add(image);
        
        JLabel text = new JLabel("SIDI BOU HOTELS WELCOMES YOU");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("reception");
        hotel.add(reception);
        
        JMenu admin = new JMenu("admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addemployee);
        JMenuItem addrooms = new JMenuItem("ADD ROOMS");
        admin.add(addrooms);
        JMenuItem adddrivers = new JMenuItem("ADD DRIVERS");
        admin.add(adddrivers);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee();
        } else if (ae.getActionCommand().equals("ADD ROOMS")) {
            new AddRooms();
        }
    }
    
    public static void main(String[] args) {
        new Dashboard();
    }
}

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
        setSize(1366, 565);
        setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1366, 565);
        add(backgroundLabel);

        JLabel titleLabel = new JLabel("HOTELEASE");
        titleLabel.setBounds(30, 420, 1000, 90);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 60));
        backgroundLabel.add(titleLabel);

        JButton nextButton = createStyledButton("Next");
        nextButton.setBounds(1150, 450, 150, 50);
        backgroundLabel.add(nextButton);

        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("SansSerif", Font.PLAIN, 24));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(255, 105, 180));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                button.setBackground(new Color(255, 182, 193));
            }

            public void mouseExited(MouseEvent evt) {
                button.setBackground(new Color(255, 105, 180));
            }
        });

        button.addActionListener(this);
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        new HotelManagementSystem();
    }
}

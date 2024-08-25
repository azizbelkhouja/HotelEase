package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {

    private JPanel contentPane;

    public Reception() {
        setBounds(530, 200, 850, 570);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(250, 30, 500, 470);
        add(l1);

        JButton btnNewCustomerForm = new JButton("New Customer Form");
        btnNewCustomerForm.setBounds(10, 30, 200, 30);
        btnNewCustomerForm.setBackground(Color.BLACK);
        btnNewCustomerForm.setForeground(Color.WHITE);
        btnNewCustomerForm.addActionListener(this);
        contentPane.add(btnNewCustomerForm);

        JButton btnNewButton = new JButton("Rooms");
        btnNewButton.setBounds(10, 70, 200, 30);
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Departments");
        btnNewButton_1.setBounds(10, 110, 200, 30);
        btnNewButton_1.setBackground(Color.BLACK);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.addActionListener(this);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Employees Info");
        btnNewButton_2.setBounds(10, 150, 200, 30);
        btnNewButton_2.setBackground(Color.BLACK);
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.addActionListener(this);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Customers Info");
        btnNewButton_3.setBounds(10, 190, 200, 30);
        btnNewButton_3.setBackground(Color.BLACK);
        btnNewButton_3.setForeground(Color.WHITE);
        btnNewButton_3.addActionListener(this);
        contentPane.add(btnNewButton_3);

        JButton btnManagerInfo = new JButton("Managers Info");
        btnManagerInfo.setBounds(10, 230, 200, 30);
        btnManagerInfo.setBackground(Color.BLACK);
        btnManagerInfo.setForeground(Color.WHITE);
        btnManagerInfo.addActionListener(this);
        contentPane.add(btnManagerInfo);

        JButton btnNewButton_4 = new JButton("Check Out");
        btnNewButton_4.setBounds(10, 270, 200, 30);
        btnNewButton_4.setBackground(Color.BLACK);
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.addActionListener(this);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("Update Check Status");
        btnNewButton_5.setBounds(10, 310, 200, 30);
        btnNewButton_5.setBackground(Color.BLACK);
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.addActionListener(this);
        contentPane.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("Update Room");
        btnNewButton_6.setBounds(10, 350, 200, 30);
        btnNewButton_6.setBackground(Color.BLACK);
        btnNewButton_6.setForeground(Color.WHITE);
        btnNewButton_6.addActionListener(this);
        contentPane.add(btnNewButton_6);

        JButton btnPickUpSerice = new JButton("Pick up Service");
        btnPickUpSerice.setBounds(10, 390, 200, 30);
        btnPickUpSerice.setBackground(Color.BLACK);
        btnPickUpSerice.setForeground(Color.WHITE);
        btnPickUpSerice.addActionListener(this);
        contentPane.add(btnPickUpSerice);

        JButton btnSearchRoom = new JButton("Search Room");
        btnSearchRoom.setBounds(10, 430, 200, 30);
        btnSearchRoom.setBackground(Color.BLACK);
        btnSearchRoom.setForeground(Color.WHITE);
        btnSearchRoom.addActionListener(this);
        contentPane.add(btnSearchRoom);

        JButton btnNewButton_7 = new JButton("Log Out");
        btnNewButton_7.setBounds(10, 470, 200, 30);
        btnNewButton_7.setBackground(Color.BLACK);
        btnNewButton_7.setForeground(Color.WHITE);
        btnNewButton_7.addActionListener(this);
        contentPane.add(btnNewButton_7);

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            switch (command) {
                case "New Customer Form":
                    new AddCustomer().setVisible(true);
                    break;
                case "Rooms":
                    new Room().setVisible(true);
                    break;
                case "Departments":
                    new Department().setVisible(true);
                    break;
                case "Employees Info":
                    new EmployeeInfo().setVisible(true);
                    break;
                case "Managers Info":
                    new ManagerInfo().setVisible(true);
                    break;
                case "Customers Info":
                    new CustomerInfo().setVisible(true);
                    break;
                case "Search Room":
                    new SearchRoom().setVisible(true);
                    break;
                case "Update Check Status":
                    new UpdateCheck().setVisible(true);
                    break;
                case "Update Room":
                    new UpdateRoom().setVisible(true);
                    break;
                // here add more cases as necessary for other buttons
                default:
                    break;
            }
            this.setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Reception();
    }
}

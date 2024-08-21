package hotel.management.system;

import javax.swing.*;
import java.awt.*;

public class AddEmployee extends JFrame implements ActionListener {
    
    AddEmployee() {
       setLayout(null);
       
       // name
       JLabel lblname = new JLabel("NAME: ");
       lblname.setBounds(60, 30, 120, 30);
       lblname.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblname);
       JTextField tfname = new JTextField();
       tfname.setBounds(200, 30, 150, 30);
       add(tfname);
       
       // age
       JLabel lblage = new JLabel("AGE: ");
       lblage.setBounds(60, 80, 120, 30);
       lblage.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblage);
       JTextField tfage = new JTextField();
       tfage.setBounds(200, 80, 150, 30);
       add(tfage);
       
       // gender
       JLabel lblgender = new JLabel("GENDER: ");
       lblgender.setBounds(60, 130, 120, 30);
       lblgender.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblgender);
       JRadioButton rbmale = new JRadioButton("Male");
       rbmale.setBounds(200, 130, 70, 30);
       lblage.setFont(new Font("serif", Font.PLAIN, 14));
       rbmale.setBackground(Color.WHITE);
       add(rbmale);
       JRadioButton rbfemale = new JRadioButton("Female");
       rbfemale.setBounds(280, 130, 70, 30);
       lblage.setFont(new Font("serif", Font.PLAIN, 14));
       rbfemale.setBackground(Color.WHITE);
       add(rbfemale);
       
       //job 
       JLabel lbljob = new JLabel("JOB: ");
       lbljob.setBounds(60, 180, 120, 30);
       lbljob.setFont(new Font("serif", Font.PLAIN, 17));
       add(lbljob);
       String str[] = {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
       JComboBox cbjob = new JComboBox(str);
       cbjob.setBounds(200, 180, 150, 30);
       cbjob.setBackground(Color.WHITE);
       add(cbjob);
       
       //salary 
       JLabel lblsalary = new JLabel("SALARY: ");
       lblsalary.setBounds(60, 230, 120, 30);
       lblsalary.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblsalary);
       JTextField tfsalary = new JTextField();
       tfsalary.setBounds(200, 230, 150, 30);
       add(tfsalary);
       
       //phone
       JLabel lblphone = new JLabel("PHONE: ");
       lblphone.setBounds(60, 280, 120, 30);
       lblphone.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblphone);
       JTextField tfphone = new JTextField();
       tfphone.setBounds(200, 280, 150, 30);
       add(tfphone);
       
       //EMAIL
       JLabel lblemail = new JLabel("EMAIL: ");
       lblemail.setBounds(60, 330, 120, 30);
       lblemail.setFont(new Font("serif", Font.PLAIN, 17));
       add(lblemail);
       JTextField tfemail = new JTextField();
       tfemail.setBounds(200, 330, 150, 30);
       add(tfemail);
       
       //submit button
       JButton submit = new JButton("SUBMIT");
       submit.setBounds(200, 430, 150, 30);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setFont(new Font("serif", Font.PLAIN, 24));
       add(submit);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
       Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(380, 60, 450, 370);
       add(image);
       
       
       getContentPane().setBackground(Color.WHITE);
       setBounds(350, 200, 850, 540);
       setVisible(true);
    } 
   
    public static void main(String[] args) {
       new AddEmployee();
    }
}

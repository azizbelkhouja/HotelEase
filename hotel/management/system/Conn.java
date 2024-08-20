package hotel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    Conn() {
        try {
            class.forName("com.mysql.cj.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "azizbelkhouja");
            s = c.createStatement();
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

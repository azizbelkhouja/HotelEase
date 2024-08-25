package hotel.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    
    public Conn() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "admin");
            s = c.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
            e.printStackTrace();
            throw e;
        }
    }
    
    public Connection getConnection() {
        return c;
    }
    
    public void close() {
        try {
            if (s != null) s.close();
            if (c != null) c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

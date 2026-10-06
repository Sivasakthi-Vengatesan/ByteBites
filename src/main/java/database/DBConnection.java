package database;
import java.sql.*;
public class DBConnection {
 private static final String URL="jdbc:mysql://localhost:3306/climatefoodordering";
 private static final String USER="root";
 private static final String PASSWORD="YOUR_MYSQL_PASSWORD";
 public static Connection getConnection(){try{Connection c=DriverManager.getConnection(URL,USER,PASSWORD);System.out.println("Database Connected Successfully!");return c;}catch(SQLException e){System.out.println("Connection Failed!");e.printStackTrace();return null;}}
}

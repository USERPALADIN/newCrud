package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseHelper {

    public static Connection getConnection() {
        String user = ("root");
        String password = ("root");
        String url = ("jdbc:mysql://localhost:3306/users" +
                "?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

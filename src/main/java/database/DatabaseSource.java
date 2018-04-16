package database;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import tables.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DatabaseSource {
    // private Connection connection;
    private  UserDAO userDAO = new UserDAO();

    private Connection getMysqlConfiguration() throws SQLException {
        String user = ("root");
        String password = ("root");
        String url = ("jdbc:mysql://localhost:3306/users" +
                "?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }

    public void addNewUser(User user) throws SQLException {
        Statement statement = getMysqlConfiguration().createStatement();
        userDAO.add(statement, user);
    }

    public void deleteUser(String id) throws SQLException {
        Statement statement = getMysqlConfiguration().createStatement();
        userDAO.delete(statement, id);
    }

    public void updateUser(User user) throws SQLException {
        Statement statement = getMysqlConfiguration().createStatement();
        userDAO.update(statement, user);
    }

    public User getUserById(String id) throws SQLException {
        Statement statement = getMysqlConfiguration().createStatement();
        return userDAO.getById(statement, id);
    }

    public List<User> getAllUsers() throws SQLException {
        Statement statement = getMysqlConfiguration().createStatement();
        return userDAO.getAll(statement);
    }

}

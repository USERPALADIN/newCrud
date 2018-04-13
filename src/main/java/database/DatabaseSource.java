package database;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import tables.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DatabaseSource {

    private Connection connection;

    public DatabaseSource() {

        //            String password = "root";
//            String name = "root";
//            String url = "jdbc:mysql://localhost:3306/users";
//            connection = DriverManager.getConnection(url, name, password);
        getMysqlConfiguration();
    }

    private void getMysqlConfiguration() {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("root");
        mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/users" +
                "?autoReconnect=true&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        try {
            connection = mysqlDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addNewUser(User user) throws SQLException {
        Statement statement = connection.createStatement();

        UserDAO userDAO = new UserDAO();
        userDAO.add(statement, user);
    }

    public void deleteUser(String login) throws SQLException {
        Statement statement = connection.createStatement();
        UserDAO userDAO = new UserDAO();
        userDAO.delete(statement, login);
    }
    public void updateUser(User user) throws SQLException {
        Statement statement = connection.createStatement();
        UserDAO userDAO = new UserDAO();
        userDAO.update(statement, user);
    }
    public User getUserByLog(String log) throws SQLException {
        Statement statement = connection.createStatement();
        UserDAO userDAO = new UserDAO();
      return   userDAO.getByLog(statement, log);
    }
    public List<User> getAllUsers() throws SQLException {
        Statement statement = connection.createStatement();
        UserDAO userDAO = new UserDAO();
       return   userDAO.getAll(statement);
    }

}

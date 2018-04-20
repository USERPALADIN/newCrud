package dao;

import database.DatabaseHelper;
import executor.Executor;
import executor.ResultHandler;
import table.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection = DatabaseHelper.getConnection();
    private Executor executor = new Executor(connection);

    public void addNewUser(User user) throws SQLException {

            executor.execUpdate("INSERT INTO user (name,login,password) "
                    + "VALUES ('" +
                    user.getName() + "' , '" +
                    user.getLogin() + "' , '"
                    + user.getPassword()
                    + "')");


        System.out.println("Прошла вставка");
    }

    public void deleteUser(int id) throws SQLException {

            executor.execUpdate("DELETE FROM user WHERE id = " + id);

    }

    public void updateUser(User user) throws SQLException {
            executor.execUpdate("UPDATE user SET " +
                    "name = '" + user.getName() + "' , " +
                    "login = '" + user.getLogin() + "' , " +
                    "password = '" + user.getPassword() +
                    "'   WHERE id = " + user.getId());

    }

    public User getUserById(int userId) throws SQLException {
        List<User> users = new ArrayList<>();

            executor.execQuery("SELECT * FROM user WHERE id =" + userId,
                    new UserExecute(users));

        return users.get(0);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

            executor.execQuery("SELECT * FROM user", new UserExecute(users));


        return users;
    }

    private class UserExecute implements ResultHandler<User> {
        List<User> users;

        UserExecute(List<User> users) {
            this.users = users;
        }

        @Override
        public List<User> handle(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"), resultSet.getString("login"),
                        resultSet.getString("password"));
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }
            return users;
        }
    }
}

package dao;

import database.DatabaseHelper;
import exception.DbException;
import executor.Executor;
import executor.ResultHandler;
import table.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements  UserDao {
    private Connection connection = DatabaseHelper.getInstance().getConnection();
    private Executor executor = new Executor(connection);
    private UserResultHandler userResultHandler = new UserResultHandler();

    public void insertUser(User user) throws DbException {

        try {
            executor.execUpdate("INSERT INTO user (name,login,password,role) "
                    + "VALUES ('" +
                    user.getName() + "' , '" +
                    user.getLogin() + "' , '" +
                    user.getPassword() +  "' , '" +
                    user.getRole() + "' )");
        } catch (SQLException e) {
            throw new DbException(e);
        }
        System.out.println("Прошла вставка");
    }

    public void deleteUser(int id) throws DbException {

        try {
            executor.execUpdate("DELETE FROM user WHERE id = " + id);
        } catch (SQLException e) {
            throw new DbException(e);
        }

    }

    public void updateUser(User user) throws DbException {
        try {
            executor.execUpdate("UPDATE user SET " +
                    "name = '" + user.getName() + "' , " +
                    "login = '" + user.getLogin() + "' , " +
                    "password = '" + user.getPassword() + "' , " +
                    "role = '" + user.getRole() +
                    "'   WHERE id = " + user.getId());
        } catch (SQLException e) {
            throw new DbException(e);
        }

    }

    public User get(int userId) throws DbException {

        try {
            List<User> users = executor.execQuery("SELECT * FROM user WHERE id =" + userId,
                    userResultHandler);
            return users.get(0);
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    public List<User> getAllUsers() throws DbException {


        try {
            List<User> users = executor.execQuery("SELECT * FROM user", userResultHandler);
            return users;
        } catch (SQLException e) {
            throw new DbException(e);
        }
    }

    @Override
    public User getByLogin(String login) throws DbException {
        try {
            List<User>  users = executor.execQuery("SELECT * FROM user WHERE login = '" + login + "'", userResultHandler);
            return users.get(0);
        } catch (Exception e) {
            throw  new DbException(e);
        }
    }

    private class UserResultHandler implements ResultHandler<User> {


        @Override
        public List<User> handle(ResultSet resultSet) throws SQLException {
            List<User> users = new LinkedList<>();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("name"), resultSet.getString("login"),
                        resultSet.getString("password"), resultSet.getString("role"));
                user.setId(resultSet.getInt("id"));
                users.add(user);
            }
            return users;
        }
    }
}

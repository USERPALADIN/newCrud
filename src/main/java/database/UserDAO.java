package database;

import tables.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void add(Statement statement, User user) {
        String query = "INSERT INTO users.user (id , name,login,password) VALUES(?,?,?,?)";
        try (PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, user.getId());
            pS.setString(2, user.getName());
            pS.setString(3, user.getLogin());
            pS.setString(4, user.getPassword());
            pS.executeUpdate();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        System.out.println("Прошла вставка");
    }

    public void delete(Statement statement, String id) {
        String query = "DELETE    FROM user WHERE id  = ? ";
        try (PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, id);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Statement statement, User user) {
        String query = "UPDATE user set   name = ?, login = ?, password  = ?    WHERE id = ? ";
        try (PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, user.getName());
            pS.setString(2, user.getLogin());
            pS.setString(3, user.getPassword());
            pS.setString(4, user.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(Statement statement, String userId ) {
        User user = null;
        String query = "SELECT * FROM user WHERE id = ? ";
        try (PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, userId);
            ResultSet set = pS.executeQuery();
            while (set.next()) {
                String id = set.getString("id");
                String name = set.getString("name");
                String login = set.getString("login");
                String password = set.getString("password");
                user = new User(id, name, login, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAll(Statement statement) {
        List<User> users = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, name, login, password);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

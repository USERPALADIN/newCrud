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
            pS.setInt(1, user.getId() );
            pS.setString(2, user.getName());
            pS.setString(3, user.getLogin());
            pS.setString(4, user.getPassword());
            pS.executeUpdate();
        } catch (SQLException sql) {
                sql.printStackTrace();
        }
        System.out.println("Прошла вставка");
    }
    public void  delete  (Statement statement, String log) {
        String query = "DELETE    FROM user WHERE login  = ? ";
        try (PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, log);
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update (Statement statement, User user) {
        String query =  "UPDATE user set   name = ?, login = ?, password  = ?    WHERE id = ? ";
        try(PreparedStatement pS = statement.getConnection().prepareStatement(query)){
            pS.setString(1, user.getName());
            pS.setString(2, user.getLogin());
            pS.setString(3, user.getPassword());
            pS.setInt(4,user.getId());
            pS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public User getByLog (Statement statement, String log) {
        User user = null;
        String query =  "SELECT * FROM user WHERE login = ? ";
        try ( PreparedStatement pS = statement.getConnection().prepareStatement(query)) {
            pS.setString(1, log);
            ResultSet set = pS.executeQuery();
            while (set.next()) {
                int id = set.getInt("id");
                String name = set.getString("name");
                String login = set.getString("login");
                String password = set.getString("password");
                user = new User(id, name,login,password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  user;
    }
    public List<User> getAll (Statement statement) {
        List<User> users = new ArrayList<>();
        try( ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                User user = new User(id, name, login, password);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  users;
    }



}

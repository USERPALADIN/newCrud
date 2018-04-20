package service;

import dao.UserDAO;
import table.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public void addNewUser(User user) {
        try {
            userDAO.addNewUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            userDAO.deleteUser(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            userDAO.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserById(int id) {
        try {
            return userDAO.getUserById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package service;

import abstractFactory.UserDaoFactory;
import abstractFactory.UserDaoFactoryImpl;
import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import exception.DbException;
import table.User;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class UserService {

    private UserDaoFactory userDaoFactory = UserDaoFactoryImpl.getInstance();
    private UserDao dao = userDaoFactory.getUserDao();


    public User getUserById(int id) {
        User user = null;
        try {
            user = dao.get(id);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return user;

    }

    public void addNewUser(User user) {

        try {
            dao.insertUser(user);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(int id) {
        try {
            dao.deleteUser(id);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            dao.updateUser(user);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    public User  getByLogin (String login) {
        User user = null;
        try {
            user =   dao.getByLogin(login);

        } catch (DbException e) {
            System.out.println("Такого пользователя нет");
        }
        return  user;
    }

    public List getAllUsers() {
        List<User> users = null;
        try {
            users = dao.getAllUsers();
        } catch (DbException e) {
            e.printStackTrace();
        }

        return users;
    }


//    public void printConnectInfo() {
//        try {
//            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
//            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
//            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
//            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
//            System.out.println("Driver: " + connection.getMetaData().getDriverName());
//            System.out.println("Autocommit: " + connection.getAutoCommit());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}

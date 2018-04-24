package service;

import dao.HibernateDAO;
import database.DatabaseHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import table.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

  //  private UserDAO userDAO = new UserDAO();


     private    Configuration configuration = DatabaseHelper.getMySqlConfiguration();
    private final SessionFactory sessionFactory = DatabaseHelper.createSessionFactory(configuration);



    public User getUserById(int id) {
        try {
            Session session = sessionFactory.openSession();
            HibernateDAO dao = new HibernateDAO(session);
            User user = dao.get(id);
            session.close();
            return user;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNewUser(User user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            HibernateDAO dao = new HibernateDAO(session);
            dao.insertUser(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            HibernateDAO dao = new HibernateDAO(session);
            dao.deleteUser(id);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            HibernateDAO dao = new HibernateDAO(session);
            dao.updateUser(user);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public List getAllUsers() {
        try {
            Session session = sessionFactory.openSession();
            HibernateDAO dao = new HibernateDAO(session);
            List<User> users = dao.getAllUsers();
            session.close();
            return users;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printConnectInfo() {
        try {
            SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
            Connection connection = sessionFactoryImpl.getConnectionProvider().getConnection();
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void addNewUser(User user) {
//        try {
//            userDAO.addNewUser(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteUser(int id) {
//        try {
//            userDAO.deleteUser(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateUser(User user) {
//        try {
//            userDAO.updateUser(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public User getUserById(int id) {
//        try {
//            return userDAO.getUserById(id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public List<User> getAllUsers() {
//        try {
//            return userDAO.getAllUsers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}

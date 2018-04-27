package service;

import dao.UserDaoHibernateImpl;
import dao.UserDao;
import exception.DbException;
import table.User;

import java.util.List;

public class UserService {

    // private UserDao dao = new UserDaoJDBCImpl();
       private UserDao dao = new UserDaoHibernateImpl();


    public User getUserById(int id)  {
        User user = null;
        try {
            user = dao.get(id);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return user;

    }

    public void addNewUser(User user)  {

        try {
            dao.insertUser(user);
        } catch (DbException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(int id)  {
        try {
            dao.deleteUser(id);
        } catch (DbException e){
            e.printStackTrace();
        }
    }

    public void updateUser(User user)  {
        try {
            dao.updateUser(user);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public List getAllUsers()  {
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

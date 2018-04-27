package dao;

import exception.DbException;
import table.User;

import java.util.List;

public interface UserDao {
     User get(int id) throws DbException;


     void insertUser(User user) throws DbException;


     void deleteUser(int id) throws DbException;

     void updateUser (User user ) throws DbException;

     List<User> getAllUsers () throws DbException;
}

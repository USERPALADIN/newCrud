package dao;

import database.DatabaseHelper;
import exception.DbException;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import table.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Configuration configuration = DatabaseHelper.getInstance().getMySqlConfiguration();
    private final SessionFactory sessionFactory = DatabaseHelper.createSessionFactory(configuration);


    public User get(int id) throws DbException {
        try {
            Session session = sessionFactory.openSession();
            return (User) session.get(User.class, id);
        } catch (HibernateException e) {
            throw new DbException(e);
        }
    }
    public void insertUser(User user) throws DbException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DbException(e);
        }

    }

    public void deleteUser(int id) throws DbException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            User user = (User) session.load(User.class, id);
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DbException(e);
        }


    }

    public void updateUser(User user) throws DbException {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (HibernateException e) {
            throw new DbException(e);
        }
    }

    public List<User> getAllUsers() throws DbException {
        try {


            Session session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(User.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new DbException(e);
        }
    }

    @Override
    public User getByLogin(String login) throws DbException {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        return ((User) criteria.add(Restrictions.eq("login", login)).uniqueResult());
    }

}


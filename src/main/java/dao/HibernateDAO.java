package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import table.User;

public class HibernateDAO {
    private Session session;

    public HibernateDAO(Session session) {
        this.session = session;
    }

    public User get(int id) throws HibernateException {
        return (User) session.get(User.class, id);
    }

//    public long getUserId(String name) throws HibernateException {
//        Criteria criteria = session.createCriteria(UsersDataSet.class);
//        return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
//    }

    public void insertUser(User user) throws HibernateException {
        session.save(user);
    }

    public void deleteUser(int id) throws HibernateException {
        User user = (User) session.load(User.class, id);
        session.delete(user);

    }
}

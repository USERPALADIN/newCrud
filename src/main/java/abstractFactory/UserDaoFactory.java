package abstractFactory;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;

public interface UserDaoFactory {
        UserDao getUserDao();
}

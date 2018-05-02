package abstractFactory;

import dao.UserDao;
import dao.UserDaoJDBCImpl;

public class JdbcImpl implements  UserDaoFactory {
    @Override
    public UserDao getUserDao() {
        return new UserDaoJDBCImpl();
    }
}

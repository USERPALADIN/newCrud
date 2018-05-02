package abstractFactory;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;

import java.io.InputStream;
import java.util.Properties;

public class UserDaoFactoryImpl implements UserDaoFactory {
    private static  UserDaoFactoryImpl userDaoFactory;

    private UserDaoFactoryImpl() {

    }

    public  static  UserDaoFactoryImpl getInstance() {
        if (userDaoFactory == null) {
            userDaoFactory = new UserDaoFactoryImpl();
        }
        return userDaoFactory;
    }

    public UserDao getUserDao() {
        InputStream fileInputStream;
        Properties properties = new Properties();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            fileInputStream = classLoader.getResourceAsStream("dao.properties");
            properties.load(fileInputStream);
            String dao = properties.getProperty("dao");
            switch (dao) {
                case "hibernate":
                    return new UserDaoHibernateImpl();
                case "jdbc":
                    return new UserDaoJDBCImpl();
                default:
                    throw new RuntimeException("Проперти не найден!  " + dao);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

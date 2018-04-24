package service;

public class HibernateService {
//    private static final String hibernate_show_sql = "true";
//    private static final String hibernate_hbm2ddl_auto = "create";

//    private final SessionFactory sessionFactory;
//
//    public HibernateService() {
//        Configuration configuration = getMySqlConfiguration();
//        sessionFactory = createSessionFactory(configuration);
//    }
//
//
//
//
//    public User getUserById(int id) {
//        try {
//            Session session = sessionFactory.openSession();
//            HibernateDAO dao = new HibernateDAO(session);
//            User user = dao.get(id);
//            session.close();
//            return user;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void addUser(User user) {
//        try {
//            Session session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//            HibernateDAO dao = new HibernateDAO(session);
//            dao.insertUser(user);
//            transaction.commit();
//            session.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteUser(int id) {
//        try {
//            Session session = sessionFactory.openSession();
//            Transaction transaction = session.beginTransaction();
//            HibernateDAO dao = new HibernateDAO(session);
//            dao.deleteUser(id);
//            transaction.commit();
//            session.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }
//
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

//    private static SessionFactory createSessionFactory(Configuration configuration) {
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
//        builder.applySettings(configuration.getProperties());
//        ServiceRegistry serviceRegistry = builder.build();
//        return configuration.buildSessionFactory(serviceRegistry);
//    }
}

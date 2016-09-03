package connection;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateConnection {
    private SessionFactory sessionFactory = null;
    private AnnotationConfiguration configuration = null;
    private static HibernateConnection hibernateConnection = null;
    
    private HibernateConnection() {
    }
    
    public static HibernateConnection getInstance() {
        if (hibernateConnection == null) {
            hibernateConnection = new HibernateConnection();
        }
        return hibernateConnection;
    }
    
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory =  configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public AnnotationConfiguration getConfiguration() {
        if (configuration == null) {
            configuration = new AnnotationConfiguration();
            configuration.configure("hibernate.cfg.xml");
        }
        return configuration;
    }
}
    

package connection;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;


/**
 * <p>
 * This class has methods for building sessionfactory and returning object. 
 * </p>
 * 
 * @author Madhan
 * 
 * @created 2016-08-27
 */
public class HibernateConnection {
    private static HibernateConnection hibernateConnection;
    private SessionFactory sessionFactory;
    
    /**
     * <p>
     * Constructor which cannot accessed from outside.
     * </p>
     */
    private HibernateConnection() { }
    
    /**
     * <p>
     * Only returns one object without creating object if not exits. 
     * </p>
     * @return
     * 		Returns this class object.
     */
    public static HibernateConnection getConnection() {
        if (null == hibernateConnection) {
            hibernateConnection = new HibernateConnection();
        }
        return hibernateConnection;
    }  
    
    /**
     * <p>
     * This method returns build session factory if not exists.
     * </p>
     * @return
     * 		Returns session factory object.
     */
    public SessionFactory getSessionFactory() {
        if (null == sessionFactory) {
            try {
                AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
                annotationConfiguration.configure("hibernate.cfg.xml");
                annotationConfiguration.addAnnotatedClass(model.EligibilityDetail.class);
                sessionFactory = annotationConfiguration.buildSessionFactory();
            } catch (HibernateException exp) {
                //FileUtil.errorLog("Exception occured in HibernateConnection/getSession()..." + exp.toString());
                System.out.println("Oops...Cannot connect kindly check your input and try again...\n");
            }
        }
        return sessionFactory;
    }
}

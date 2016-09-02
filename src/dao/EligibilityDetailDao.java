package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.EligibilityDetail;

/**
 * <p>
 * Dao class which has methods for adding, updating, removing, etc., user eligibility details into database.
 * </p>
 * 
 * @author Madhan
 * 
 * @since 2016-08-27
 */
public class EligibilityDetailDao {

    private HibernateConnection hibernateConnection = HibernateConnection.getConnection();
    private SessionFactory sessionFactory = hibernateConnection.getSessionFactory();
    private Session session;
    private Transaction transaction;
    
    /**
	 * <p>
	 * To insert a eligibility details into table using session.
	 * </p> 
     * @param employee
     * 		Its a object from service method
     * @return
     * 		Returns true or false to service method.
     * @throws ApplicationException
     * 		If there is any error in hibernate configuration.
     */
    public boolean insertEligibilityDetail(EligibilityDetail eligibilityDetail) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(eligibilityDetail);
            transaction.commit();
            return true;
        } catch (HibernateException exp) {
            transaction.rollback();
            throw new ApplicationException("Oops...Cannot add kindly check your input and try again...\n", exp);    
        } finally {
            session.close();           
        }
    }    

}

package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.EligibilityDetail;

/**
 * Dao class which has methods for adding user eligibility details into database.
 * 
 * @author Madhan
 * 
 * @since 2016-08-27
 */
public class EligibilityDetailDao {

	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;
    
    /**
	 * <p>
	 * To insert a eligibility details into table using session.
	 * </p> 
     * @param eligibilityDetail
     * 		Its a object from service method.
     * @return
     * 		Returns true or false to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
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
            return false;
        } finally {
            session.close();           
        }
    }    

}

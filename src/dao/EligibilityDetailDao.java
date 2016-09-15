package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ConfigurationException;
import exception.DatabaseException;
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
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public boolean insertEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(eligibilityDetail);
            transaction.commit();
            return true;
        } catch (HibernateException exp) {
        	throw new DatabaseException("Oops...Cant add eligibilityDetail Kindly check your input and try again...\n", exp);            
        } finally {
            session.close();           
        }
    }    
    
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
    public List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<EligibilityDetail> eligibilityDetails = session.createQuery("from EligibilityDetail where user_id="+userId).list();
            transaction.commit();
            return eligibilityDetails;
        } catch (HibernateException exp) {
            transaction.rollback();
            throw new DatabaseException("Error occured in retrieving the eligibility details", exp);
        } finally {
            session.close();           
        }
    }     
}

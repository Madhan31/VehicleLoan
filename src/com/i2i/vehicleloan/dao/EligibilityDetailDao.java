package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;

/**
 * Dao class which has methods for adding user eligibility details into database.
 * 
 * @author Madhan
 * 
 * @since 2016-09-06
 */
public class EligibilityDetailDao {

	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
    
    /**
	 * To insert a eligibility details into table using session.
	 * 
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
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
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
	 * To retrieve all the eligibility detail by using user ID.
	 *  
     * @param eligibilityDetail
     * 		Its a value from service method.
     * @return
     * 		Returns list of object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    public List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<EligibilityDetail> eligibilityDetails = session.createQuery("from EligibilityDetail where user_id="+userId).list();
            transaction.commit();
            return eligibilityDetails;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrieving the eligibility details", exp);
        } finally {
            session.close();           
        }
    }  
    
    /**
     * To retrieve the eligibility detail by using vehicle model ID.
     * 
     * @param paymentId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public EligibilityDetail retrieveEligibilityDetail(int vehicleModelId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            EligibilityDetail eligibilityDetail = (EligibilityDetail) session.createQuery("from EligibilityDetail where vehicle_model_id = '"+vehicleModelId+"'");
            transaction.commit();
            return eligibilityDetail;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        } finally {
            session.close();
        }
    }
}

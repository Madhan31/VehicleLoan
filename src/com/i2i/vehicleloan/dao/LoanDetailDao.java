package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.LoanDetail;

/**
 * Dao class which has methods for adding, retrieving user loan detail into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
public class LoanDetailDao {
	
	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loanDetail
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addLoanDetail(LoanDetail loanDetail) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loanDetail);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in add the values in loan detail", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * Retrieve all loan detail from database and returns to service method. 
     * 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file. 
     */
    public List<LoanDetail> retrieveLoanDetails() throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<LoanDetail> loanDetail = session.createQuery("from LoanDetail").list();
            transaction.commit();
            return loanDetail;
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exp);
        } finally {
            session.close();
        }
    }    
    
    /**
     * Retrieve all loan detail by using loan id from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
    public List<LoanDetail> retrieveLoanDetailsByLoanId(int loanId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<LoanDetail> loanDetail = session.createQuery("from LoanDetail where loan_id = '"+loanId+"'").list();
            transaction.commit();
            return loanDetail;
        } catch (HibernateException exp) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exp);
        } finally {
            session.close();
        }
    } 
    
    /**
     * Retrieve all loan detail by using user id from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetch all the loan detail want to retrieve. 
     * @return
     *     It return retrieve list of loan detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file. 
     */
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<LoanDetail> loanDetails = session.createQuery("from LoanDetail where user_id = "+userId).list();
            transaction.commit();
            return loanDetails;
        } catch (HibernateException exception) {
            throw new  DatabaseException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
}

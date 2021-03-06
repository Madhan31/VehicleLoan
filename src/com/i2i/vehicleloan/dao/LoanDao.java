package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Loan;

/**
 * Dao class which has methods for adding, removing, retrieving user loan details into database.
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
 */
public class LoanDao {
	
	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
    
    /**
     * To add the loan detail into database by using session.
     * 
     * @param loan
     *     Its object from service method.It contains the loan detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    public void addLoan(Loan loan) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in loan", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the loan detail from database by using the loan id.
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void removeLoan(int loanId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();  
            Loan loan = (Loan) session.load(Loan.class, loanId);
            session.delete(loan);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove the loan details in loan", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * Retrieve loan detail from database and returns to service method. 
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to retrieve. 
     * @return
     *    It return loan object to service.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public Loan retrieveLoan(int loanId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Loan loan = (Loan) session.get(Loan.class, loanId);
            transaction.commit();
            return loan;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the loan details in loan", exp);
        } finally {
            session.close();
        }
    } 
    
    /**
     * Retrieve all loan detail by using userId from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetchn all the loan detail want to retrieve. 
     * @return
     *     It return list of loan object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public List<Loan> retrieveLoansByUserId(int userId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Loan> loans = session.createQuery("from Loan where user_id = '"+userId+"'").list();
            transaction.commit();
            return loans;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the loan details in loan", exp);
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
    public List<Loan> retreieveAllLoans() throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Loan> loans = session.createQuery("from Loan").list();
            transaction.commit();
            return loans;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occur in retrive all loan details in loan", exp);
        } finally {
            session.close();
        }
     }
    
    /**
     * To retrieve the loan detail by using eligibility detail ID.
     * 
     * @param eligibilityDetailId
     *     It is the value from service to to get a specific detail from database.
     * @return
     *     It return a object to service method
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public Loan retrieveLoanByEligibilityDetailId(int eligibilityDetailId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Loan loan = (Loan) session.createQuery("from loan where eligibility_detail_id = '"+eligibilityDetailId+"'");
            transaction.commit();
            return loan;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        } finally {
            session.close();
        }
    }
}

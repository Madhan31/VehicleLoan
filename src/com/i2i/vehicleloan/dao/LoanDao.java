package com.i2i.vehicleloan.dao;

import java.util.List;
import java.util.ArrayList;

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
 */
public class LoanDao {
	
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
        } catch(HibernateException e) {
            throw new DatabaseException("Error occured in add the values in loan", e);
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Loan loan;
        try {
            transaction = session.beginTransaction();  
            loan = (Loan) session.load(Loan.class, loanId);
            session.delete(loan);
            transaction.commit();
        } catch(HibernateException exception) {
            throw new DatabaseException("Error occured in remove the loan details in loan", exception);
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Loan loan;
        try {
            transaction = session.beginTransaction();
            loan = (Loan) session.get(Loan.class, loanId);
            transaction.commit();
            return loan;
        } catch(HibernateException exception) {
            throw new DatabaseException("Error occured in retrive the loan details in loan", exception);
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Loan> loans = session.createQuery("from Loan where user_id = '"+userId+"'").list();
            transaction.commit();
            return loans;
        } catch(HibernateException exception) {
        	transaction.rollback();
            throw new DatabaseException("Error occured in retrive the loan details in loan", exception);
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
        Session session = sessionFactory.openSession();
        List<Loan> loans = new ArrayList<Loan>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            loans = session.createQuery("from Loan").list();
            transaction.commit();
        } catch(HibernateException exception) {
            throw new DatabaseException("Error occur in retrive all loan details in loan", exception);
        } finally {
            session.close();
        }
        return loans;
    }
    
}

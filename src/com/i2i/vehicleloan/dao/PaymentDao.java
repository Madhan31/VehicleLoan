package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Payment;

/**
 * Dao class which has methods for adding, retrieving user payment detail into database.
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public class PaymentDao {
	
	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
    
    /**
     * To add the payment detail into database by using session.
     * 
     * @param payment
     *     Its object from service method.It contains the payment detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addPayment(Payment payment) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in payment", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * Retrieve payment detail by using payment id from database and returns to service method. 
     * 
     * @param paymentId
     *     Get loan id from service to fetch the payment detail want to retrieve. 
     * @return
     *     It return retrieve of payment detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public Payment retrievePayment(int paymentId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Payment payment = (Payment) session.get(Payment.class, paymentId);
            transaction.commit();
            return payment;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * Retrieve all payment detail by using userId from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetchn all the loan detail want to retrieve. 
     * @return
     *     It return list of loan object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Payment> payments = session.createQuery("from Payment where loan_id = '"+loanId+"'").list();
            transaction.commit();
            return payments;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exp);
        } finally {
            session.close();
        }
    }     
}

package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ConfigurationException;
import exception.DatabaseException;
import model.Payment;

/**
 * Dao class which has methods for adding, retrieving user payment detail into database.
 * 
 * @author vicky
 *
 */
public class PaymentDao {
	
	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch(HibernateException e) {
            throw new DatabaseException("Error occured in add the values in payment", e);
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
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Payment payment;
        try {
            transaction = session.beginTransaction();
            payment = (Payment) session.get(Payment.class, paymentId);
            transaction.commit();
            return payment;
        } catch(HibernateException exception) {
            throw new DatabaseException("Error occured in retrive the payment details in payment", exception);
        } finally {
            session.close();
        }
    }
}

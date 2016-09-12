package dao;

import org.hibernate.cfg.AnnotationConfiguration;

import connection.HibernateConnection;
import exception.ApplicationException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Payment;

/**
 * Dao class which has methods for adding, retrieving user payment detail into database.
 * 
 * @author admin-pc
 *
 */
public class PaymentDao {
	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
    
    /**
     * To add the payment detail into database by using session.
     * 
     * @param payment
     *     Its object from service method.It contains the payment detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addPayment(Payment payment) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(payment);
            transaction.commit();
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in add the values in payment", e);
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
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Payment retrievePayment(int paymentId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Payment payment;
        try {
            transaction = session.beginTransaction();
            payment = (Payment) session.get(Payment.class, paymentId);
            transaction.commit();
            return payment;
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in retrive the payment details in payment", exception);
        } finally {
            session.close();
        }
    }
}

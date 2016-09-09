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

public class PaymentDao {
	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
    
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

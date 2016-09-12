package dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Loan;

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
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoan(Loan loan) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loan);
            transaction.commit();
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in add the values in loan", e);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the loan detail from database by using the loan id.
     * 
     * @param loanId
     *     Get loan id from service to fetch the particular loan detail want to remove. 
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void removeLoan(int loanId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Loan loan;
        try {
            transaction = session.beginTransaction();  
            loan = (Loan) session.load(Loan.class, loanId);
            session.delete(loan);
            transaction.commit();
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in remove the loan details in loan", exception);
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
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Loan retrieveLoan(int loanId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        Loan loan;
        try {
            transaction = session.beginTransaction();
            loan = (Loan) session.get(Loan.class, loanId);
            transaction.commit();
            return loan;
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
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
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Loan> retrieveLoansByUserId(int userId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Loan> loans = session.createQuery("from Loan where user_id ="+userId).list();
            transaction.commit();
            return loans;
        } catch(HibernateException exception) {
        	transaction.rollback();
        	exception.printStackTrace();
        	return null;
            //throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
    
    /**
     * Retrieve all loan detail from database and returns to service method. 
     * 
     * @return
     *     It return list of loan object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
     public List<Loan> retreieveAllLoans() throws ApplicationException {
        Session session = sessionFactory.openSession();
        List<Loan> loans = new ArrayList<Loan>();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            loans = session.createQuery("from Loan").list();
            transaction.commit();
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occur in retrive all loan details in loan", exception);
        } finally {
            session.close();
        }
        return loans;
    }
    
}

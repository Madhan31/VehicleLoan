package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Loan;
import model.LoanDetail;


public class LoanDetailDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
    public void addLoanDetail(LoanDetail loanDetail) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(loanDetail);
            transaction.commit();
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in add the values in loan", e);
        } finally {
            session.close();
        }
    }
    
    public List<LoanDetail> retrieveLoanDetails() throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<LoanDetail> loanDetail = session.createQuery("from LoanDetail").list();
            transaction.commit();
            return loanDetail;
        } catch(HibernateException exception) {
        	transaction.rollback();
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    }    
    
    public List<LoanDetail> retrieveLoanDetailsByLoanId(int loanId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<LoanDetail> loanDetail;
        try {
            transaction = session.beginTransaction();
            loanDetail = session.createQuery("from LoanDetail where loan_id =  '"+loanId+"'").list();
            transaction.commit();
            return loanDetail;
        } catch(HibernateException exception) {
        	transaction.rollback();
        	exception.printStackTrace();
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
    
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<LoanDetail> loanDetails = session.createQuery("from LoanDetail where user_id ="+userId).list();
            transaction.commit();
            return loanDetails;
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
    
}

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


public class LoanDao {
    private HibernateConnection hibernateConnection = HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
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
    
    public List<Loan> retrieveLoansByUserId(int userId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Loan> loans = new ArrayList<Loan>();
        try {
            transaction = session.beginTransaction();
            loans = (List<Loan>) session.createQuery("from Loan where user_id ="+userId).list();
            transaction.commit();
            return loans;
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
    
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

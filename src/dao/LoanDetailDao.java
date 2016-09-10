package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
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
    
    public LoanDetail retrieveLoanDetail(int loanId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        LoanDetail loanDetail;
        try {
            transaction = session.beginTransaction();
            loanDetail = (LoanDetail) session.get(LoanDetail.class, loanId);
            transaction.commit();
            return loanDetail;
        } catch(HibernateException exception) {
            throw new ApplicationException("Error occured in retrive the loan details in loan", exception);
        } finally {
            session.close();
        }
    } 
}

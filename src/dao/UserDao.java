package dao;

import connection.HibernateConnection;
import exception.ApplicationException;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.User;

public class UserDao {
    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
    public void addUser(User user) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            System.out.println(user);
            session.save(user);
            transaction.commit();
        } catch(HibernateException exp) {
            transaction.rollback();
            exp.printStackTrace();
            //throw new ApplicationException("Error occured in add the values in user", exp);
        } finally {
            session.close();
        }
    }
    
    public User retrieveUser(int userId) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, userId);
            transaction.commit();
            return user;
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in retrive the user details in user", exp);
        } finally {
            session.close();
        }
    } 
    
    public List<User> retrieveUserByMobileNumber(long mobileNumber) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<User> user;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("from User where mobileNumber=: mobileNumber");
            query.setParameter("mobileNumber", "mobileNumber");
            user = query.list();
            transaction.commit();
            return user;
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in retrive the user details in user", exp);
        } finally {
            session.close();
        }
    } 
}
    
    

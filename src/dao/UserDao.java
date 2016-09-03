package dao;


import connection.HibernateConnection;
import exception.ApplicationException;

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
            session.save(user);
            transaction.commit();
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in add the values in account", e);
        } finally {
            session.close();
        }
    }
    
    public User retrieveUser(String phoneNumber) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, phoneNumber);
            transaction.commit();
            return user;
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in retrive the account details in account", e);
        } finally {
            session.close();
        }
    } 
}
    
    

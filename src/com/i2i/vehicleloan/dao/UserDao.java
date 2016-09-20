package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.User;

/**
 * Dao class which has methods for adding, retrieving user detail into database.
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public class UserDao {
	
    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;
    
    /**
     * To add the user detail into database by using session.
     * 
     * @param user
     *     Its object from service method.It contains the user detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file. 
     */
    public void addUser(User user) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in user", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * Retrieve user detail by using user id from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetch the payment detail want to retrieve. 
     * @return
     *     It return retrieve of user detail object to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    public User retrieveUser(int userId) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            User user = (User) session.get(User.class, userId);
            transaction.commit();
            return user;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the user details in user", exp);
        } finally {
            session.close();
        }
    } 
    
    /**
     * Retrieve all user detail from database and returns to service method. 
     * 
     * @param userId
     *     Get user id from service to fetch the payment detail want to retrieve. 
     * @return
     *     It return retrieve of user detail object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<User> retrieveAllUsers() throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<User> users = session.createQuery("from User").list();
            transaction.commit();
            return users;
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in retrive the users detail in user", exp);
        } finally {
            session.close();
        }
    }     
}
    
    

package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.User;

/**
 * Dao class which has methods for adding, retrieving user detail into database.
 * 
 * @author vicky
 *
 */
public class UserDao {
	
    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    
    /**
     * To add the user detail into database by using session.
     * 
     * @param user
     *     Its object from service method.It contains the user detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addUser(User user) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch(HibernateException exp) {
            transaction.rollback();
            throw new ApplicationException("Error occured in add the values in user", exp);
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
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
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
        	exp.printStackTrace();
            throw new ApplicationException("Error occured in retrive the user details in user", exp);
        } finally {
            session.close();
        }
    } 
}
    
    

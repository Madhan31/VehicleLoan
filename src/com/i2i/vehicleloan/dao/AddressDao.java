package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Address;

/**
 * Dao class which has methods for adding address details in database.
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
public class AddressDao {
	
	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
    	
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
	public void insertAddress(Address address) throws DatabaseException, ConfigurationException {
		SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cannot add address kindly check your input and try again...\n", exp);    
        } finally {
            session.close();           
        }		
	}
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
	public List<Address> retrieveAddressesByUserId(int userId) throws DatabaseException, ConfigurationException {
		SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Address> addresses = session.createQuery("from Address where user_id="+userId).list();
            transaction.commit();
            return addresses;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cannot retrieve address kindly check your input and try again...\n", exp);    
        } finally {
            session.close();           
        }		
	}	
}

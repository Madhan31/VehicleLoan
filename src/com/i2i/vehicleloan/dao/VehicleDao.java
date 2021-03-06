package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Vehicle;

/**
 * Dao class which has methods for adding, removing, retrieving vehicle detail into database.
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public class VehicleDao {
	
	private SessionFactory hibernateConnection() throws ConfigurationException { 
	    HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	    SessionFactory sessionFactory = hibernateConnection.establishConnection();
	    return sessionFactory;
	}
	
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     * 	   Returns vehicle list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    public List<Vehicle> retrieveVehicles() throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Vehicle> vehicles = session.createQuery("from Vehicle").list();
            transaction.commit();
            return vehicles;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve Kindly check your input and try again...", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addVehicle(Vehicle vehicle) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in vehicle", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the vehicle detail from database by using session.
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch the vehicle detail want to remove.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void removeVehicle(int vehicleId) throws DatabaseException, ConfigurationException {
    	SessionFactory sessionFactory = hibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();  
            Vehicle vehicle = (Vehicle) session.load(Vehicle.class, vehicleId);
            session.delete(vehicle);
            transaction.commit();
        } catch (HibernateException exp) {
            throw new DatabaseException("Error occured in remove the vehicle details in vehicle", exp);
        } finally {
            session.close();
        }
    }	
}

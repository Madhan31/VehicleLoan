package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Vehicle;

/**
 * Dao class which has methods for adding, removing, retrieving vehicle detail into database.
 * 
 * @author vicky
 *
 */
public class VehicleDao {
	
    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
    /**
     * Retrieve all vehicles from database and returns to service method. 
     * 
     * @return
     * 	   Returns vehicle list to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Vehicle> retrieveVehicles() throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<Vehicle> vehicles = session.createQuery("from Vehicle").list();
            transaction.commit();
            return vehicles;
        } catch (HibernateException exp) {
            throw new ApplicationException("Oops...Cant retrieve Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicle
     *     Its object from service method.It contains the vehicle detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addVehicle(Vehicle vehicle) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in add the values in vehicle", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the vehicle detail from database by using session.
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch the vehicle detail want to remove.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void removeVehicle(int vehicleId) throws ApplicationException {
        session = sessionFactory.openSession();
        Vehicle vehicle;
        try {
            transaction = session.beginTransaction();  
            vehicle = (Vehicle) session.load(Vehicle.class, vehicleId);
            session.delete(vehicle);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in remove the vehicle details in vehicle", exp);
        } finally {
            session.close();
        }
    }	
}

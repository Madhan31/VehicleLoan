package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Vehicle;

public class VehicleDao {
	
    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
    /**
     * <p>
     * Retrieve all vehicles from database and returns to service method. 
     * </p>
     * @return
     * 		Returns vehicle list to service method.
     * @throws DatabaseException
     * 		if there is any error in hibernate configuration.
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

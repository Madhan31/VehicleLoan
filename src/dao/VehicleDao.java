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
        } catch (Exception exp) {
            throw new ApplicationException("Oops...Cant retrieve Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }
    }	

}

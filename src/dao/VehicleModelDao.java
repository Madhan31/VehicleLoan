package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.VehicleModel;

public class VehicleModelDao {

	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
    
    public VehicleModel getVehicleModelById(int vehicleModelId) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            VehicleModel vehicleModel = (VehicleModel)session.get(VehicleModel.class, vehicleModelId);
            transaction.commit();
            return vehicleModel;
        } catch (Exception exp) {
            throw new ApplicationException("Oops...Cant retrieve vehicelModel Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }	
    }    
    
    public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<VehicleModel> vehicleModels = session.createQuery("from VehicleModel where vehicle_id ="+vehicleId).list();
            transaction.commit();
            return vehicleModels;
        } catch (Exception exp) {
            throw new ApplicationException("Oops...Cant retrieve vehicelModel Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }	
    }
    
    /**
     * <p>
     * Retrieve all vehicleModels from database and returns to service method. 
     * </p>
     * @return
     * 		Returns vehicleModel list to service method.
     * @throws DatabaseException
     * 		if there is any error in hibernate configuration.
     */
    public List<VehicleModel> retrieveVehicleModels() throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<VehicleModel> vehicleModels = session.createQuery("from VehicleModel").list();
            transaction.commit();
            return vehicleModels;
        } catch (Exception exp) {
            throw new ApplicationException("Oops...Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }
    }	
	
	
}

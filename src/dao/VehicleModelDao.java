package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.VehicleModel;

/**
 * Dao class which has methods for adding, removing, retrieving vehicle model detail into database.
 * 
 * @author vicky
 *
 */
public class VehicleModelDao {

    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
    
    /**
     * Retrieve vehicle model detail from database and returns to service method.
     *  
     * @param vehicleModelId
     *     Get vehicle model id from service to fetch the vehicle detail want to retrieve.
     * @return
     *     It return the vehicle model object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
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
    
    /**
     * Retrieve all vehicle model detail by using vehicle id from database and returns to service method. 
     * 
     * @param vehicleId
     *     Get vehicle id from service to fetch all the vehicle detail want to retrieve. 
     * @return
     *     It return retrieve list of vehicle detail object to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
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
     * Retrieve all vehicleModels from database and returns to service method. 
     * 
     * @return
     * 		Returns vehicleModel list to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
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
    
    /**
     * To add the vehicle detail into database by using session.
     * 
     * @param vehicleModel
     *     Its object from service method.It contains the vehicle model detail of vehicle.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addVehicleModel(VehicleModel vehicleModel) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(vehicleModel);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in add the values in vehicle model", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the vehicle model detail from database by using session.
     * 
     * @param vehicleModelId
     *     Get vehicle model id from service to fetch the vehicle model detail want to remove.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void removeVehicleModel(int vehicleModelId) throws ApplicationException {
        session = sessionFactory.openSession();
        VehicleModel vehicleModel;
        try {
            transaction = session.beginTransaction();  
            vehicleModel = (VehicleModel) session.load(VehicleModel.class, vehicleModelId);
            session.delete(vehicleModel);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in remove the vehicle model details", exp);
        } finally {
            session.close();
        }
    }	
}

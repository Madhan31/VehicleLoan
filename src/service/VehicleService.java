package service;

import java.util.List;

import dao.VehicleDao;
import exception.ApplicationException;
import model.Vehicle;

/**
 * <p>
 * Vehicle service class which has methods for adding, removing, retrieve vehicle details.
 * It contain all the business logic operation of vehicle class.
 * </p> 
 * 
 * @author vicky
 *
 */
public class VehicleService {
	
    private VehicleDao vehicleDao = new VehicleDao();
	
    /**
     * Retrieve all the vehicle details.
     * 
     * @return
     *     It return list of vehicle object to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Vehicle> retrieveVehicles() throws ApplicationException {
        return vehicleDao.retrieveVehicles();		
    }
    
    /**
     * Call vehicle dao for add new vehicle detail.
     * @param vehicle
	 *     Get the vehicle object from controller.
     * @return
     *     Its return notification message to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public String addVehicle(Vehicle vehicle) throws ApplicationException {
        vehicleDao.addVehicle(vehicle);
        return "Vehicle details added successfully";
    }
    
    /**
     * Call vehicle dao for remove vehicle detail.
     * 
     * @param vehicleId
	 *     Get vehicle id from controller to remove detail of specified vehicle. 
     * @return
     *     Its return notification message to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public String removeVehicle(int vehicleId) throws ApplicationException {
        vehicleDao.removeVehicle(vehicleId);
        return "Vehicle details deleted successfully";
    }    
}

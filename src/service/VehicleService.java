package service;

import java.util.List;

import dao.VehicleDao;
import exception.ApplicationException;
import model.Vehicle;

/**
 * 
 * @author vicky
 *
 */
public class VehicleService {
	
    private VehicleDao vehicleDao = new VehicleDao();
	
    /**
     * 
     * @return
     * @throws ApplicationException
     */
    public List<Vehicle> retrieveVehicles() throws ApplicationException {
        return vehicleDao.retrieveVehicles();		
    }
    
    /**
     * 
     * @param vehicle
     * @return
     * @throws ApplicationException
     */
    public String addVehicle(Vehicle vehicle) throws ApplicationException {
        vehicleDao.addVehicle(vehicle);
        return "Vehicle details added successfully";
    }
    
    /**
     * 
     * @param vehicleId
     * @return
     * @throws ApplicationException
     */
    public String removeVehicle(int vehicleId) throws ApplicationException {
        vehicleDao.removeVehicle(vehicleId);
        return "Vehicle details deleted successfully";
    }    
}

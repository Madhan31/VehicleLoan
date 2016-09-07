package service;

import java.util.List;

import dao.VehicleDao;
import exception.ApplicationException;
import model.Vehicle;

public class VehicleService {
	
    private VehicleDao vehicleDao = new VehicleDao();
	
    public List<Vehicle> retrieveVehicles() throws ApplicationException {
        return vehicleDao.retrieveVehicles();		
    }
    
    public void addVehicle(Vehicle vehicle) throws ApplicationException {
        vehicleDao.addVehicle(vehicle);
    }
    
    public void removeVehicle(int vehicleId) throws ApplicationException {
        vehicleDao.removeVehicle(vehicleId);
    }    
        
}

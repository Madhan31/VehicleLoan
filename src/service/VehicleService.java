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
    
    public String addVehicle(Vehicle vehicle) throws ApplicationException {
        vehicleDao.addVehicle(vehicle);
        return "Vehicle details added successfully";
    }
    
    public String removeVehicle(int vehicleId) throws ApplicationException {
        vehicleDao.removeVehicle(vehicleId);
        return "Vehicle details deleted successfully";
    }    
        
}
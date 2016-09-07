package service;

import java.util.List;

import dao.VehicleModelDao;
import exception.ApplicationException;
import model.VehicleModel;

public class VehicleModelService {
	
    private VehicleModelDao vehicleModelDao = new VehicleModelDao();
	
	public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelsByVehicleId(vehicleId);
	}
	
	public VehicleModel getVehicleModelById(int vehicleModelId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelById(vehicleModelId);		
	}	
	
	public List<VehicleModel> retrieveVehicleModels() throws ApplicationException {
		return vehicleModelDao.retrieveVehicleModels();		
	}
	
	public String addVehicleModel(VehicleModel vehicleModel) throws ApplicationException {
            vehicleModelDao.addVehicleModel(vehicleModel);
            return "Vehicle model details added successfully";
        }
        
        public String removeVehicleModel(int vehicleModelId) throws ApplicationException {
            vehicleModelDao.removeVehicleModel(vehicleModelId);
            return "Vehicle model details deleted successfully";
        }  

}
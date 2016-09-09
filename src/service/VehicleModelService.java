package service;

import java.util.List;

import dao.VehicleModelDao;
import exception.ApplicationException;
import model.VehicleModel;

/**
 * 
 * @author vicky
 *
 */
public class VehicleModelService {
	
    private VehicleModelDao vehicleModelDao = new VehicleModelDao();
	
    /**
     * 
     * @param vehicleId
     * @return
     * @throws ApplicationException
     */
	public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelsByVehicleId(vehicleId);
	}
	
	/**
	 * 
	 * @param vehicleModelId
	 * @return
	 * @throws ApplicationException
	 */
	public VehicleModel getVehicleModelById(int vehicleModelId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelById(vehicleModelId);		
	}	
	
	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	public List<VehicleModel> retrieveVehicleModels() throws ApplicationException {
		return vehicleModelDao.retrieveVehicleModels();		
	}
	
	/**
	 * 
	 * @param vehicleModel
	 * @return
	 * @throws ApplicationException
	 */
	public String addVehicleModel(VehicleModel vehicleModel) throws ApplicationException {
            vehicleModelDao.addVehicleModel(vehicleModel);
            return "Vehicle model details added successfully";
    }
    
	/**
	 * 
	 * @param vehicleModelId
	 * @return
	 * @throws ApplicationException
	 */
    public String removeVehicleModel(int vehicleModelId) throws ApplicationException {
        vehicleModelDao.removeVehicleModel(vehicleModelId);
        return "Vehicle model details deleted successfully";
    }  
}

package service;

import java.util.List;

import dao.VehicleModelDao;
import exception.ApplicationException;
import model.VehicleModel;

/**
 * <p>
 * Vehicle model service class which has methods for adding, removing, retrieve vehicle model details.
 * It contain all the business logic operation of vehicle model class.
 * </p> 
 * 
 * @author vicky
 *
 */
public class VehicleModelService {
	
    private VehicleModelDao vehicleModelDao = new VehicleModelDao();
	
    /**
     * Retrieve all the vehicle model details by vehicle id.
     * 
     * @param vehicleId
     *     Get vehicle id from controller for retrieve all the vehicle model detail.  
     * @return
     *     It return list of vehicle model object to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
	public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelsByVehicleId(vehicleId);
	}
	
	/**
	 * Retrieve particular vehicle model detail by vehicle id.
	 * 
	 * @param vehicleModelId
     *     Get vehicle id from controller for retrieve a vehicle model detail.  
	 * @return
	 *     It return a retrieve vehicle model object to controller.
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public VehicleModel getVehicleModelById(int vehicleModelId) throws ApplicationException {
		return vehicleModelDao.getVehicleModelById(vehicleModelId);		
	}	
	
	/**
     * Retrieve all the vehicle model details.
     * 
	 * @return
     *     It return list of vehicle model object to controller.
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public List<VehicleModel> retrieveVehicleModels() throws ApplicationException {
		return vehicleModelDao.retrieveVehicleModels();		
	}
	
	/**
     * Call vehicle model dao for add new vehicle model detail.
     * 
	 * @param vehicleModel
	 *     Get the vehicle model object from controller.
	 * @return
     *     Its return notification message to controller.
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public String addVehicleModel(VehicleModel vehicleModel) throws ApplicationException {
            vehicleModelDao.addVehicleModel(vehicleModel);
            return "Vehicle model details added successfully";
    }
    
	/**
	 * Call vehicle model dao for remove vehicle model detail.
	 * 
	 * @param vehicleModelId
	 *     Get vehicle model id from controller to remove detail of specified model. 
	 * @return
     *     Its return notification message to controller.
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
    public String removeVehicleModel(int vehicleModelId) throws ApplicationException {
        vehicleModelDao.removeVehicleModel(vehicleModelId);
        return "Vehicle model details deleted successfully";
    }  
}

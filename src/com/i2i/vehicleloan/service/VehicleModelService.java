package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.dao.VehicleModelDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.VehicleModel;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * Vehicle model service class which has methods for adding, removing, retrieve vehicle model details.
 * It contain all the business logic operation of vehicle model class.
 * </p> 
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public class VehicleModelService {
	
    private VehicleModelDao vehicleModelDao = new VehicleModelDao();
    private EligibilityDetailService eligibilityDetailService = new EligibilityDetailService();
	
    /**
     * Retrieve all the vehicle model details by vehicle id.
     * 
     * @param vehicleId
     *     Get vehicle id from controller for retrieve all the vehicle model detail.  
     * @return
     *     It return list of vehicle model object to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */
	public List<VehicleModel> getVehicleModelsByVehicleId(int vehicleId) throws DatabaseException, ConfigurationException {
		return vehicleModelDao.getVehicleModelsByVehicleId(vehicleId);
	}
	
	/**
	 * Retrieve particular vehicle model detail by vehicle id.
	 * 
	 * @param vehicleModelId
     *     Get vehicle id from controller for retrieve a vehicle model detail.  
	 * @return
	 *     It return a retrieve vehicle model object to controller.
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
	public VehicleModel getVehicleModelById(int vehicleModelId) throws DatabaseException, ConfigurationException {
		if (ValidationUtil.isAlphabetic(String.valueOf(vehicleModelId))) {
		    return vehicleModelDao.getVehicleModelById(vehicleModelId);
		}
		throw new DatabaseException("Please enter number only in model id");
	}	
	
	/**
     * Retrieve all the vehicle model details.
     * 
	 * @return
     *     It return list of vehicle model object to controller.
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
	public List<VehicleModel> retrieveVehicleModels() throws DatabaseException, ConfigurationException {
		return vehicleModelDao.retrieveVehicleModels();		
	}
	
	/**
     * Call vehicle model dao for add new vehicle model detail.
     * 
	 * @param vehicleModel
	 *     Get the vehicle model object from controller.
	 * @return
     *     Its return notification message to controller.
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
	public String addVehicleModel(VehicleModel vehicleModel) throws DatabaseException, ConfigurationException {
        if (ValidationUtil.isNumeric(String.valueOf(vehicleModel.getPrice()))) {
		    vehicleModelDao.addVehicleModel(vehicleModel);
            return "Vehicle model details added successfully";
        }
        throw new DatabaseException("Please enter number only in price");
	}
    
	/**
	 * Call vehicle model dao for remove vehicle model detail.
	 * 
	 * @param vehicleModelId
	 *     Get vehicle model id from controller to remove detail of specified model. 
	 * @return
     *     Its return notification message to controller.
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
    public String removeVehicleModel(int vehicleModelId) throws DatabaseException, ConfigurationException {
    	if (ValidationUtil.isAlphabetic(String.valueOf(vehicleModelId))) {
    	    if (!(eligibilityDetailService.isVehicleModelExist(vehicleModelId))) {
                vehicleModelDao.removeVehicleModel(vehicleModelId);
                return "Vehicle model details deleted successfully";
    	    }
    	    return "This vehicle model have a loan ";
        }
    	throw new DatabaseException("Please enter number only in model id");
    }
}

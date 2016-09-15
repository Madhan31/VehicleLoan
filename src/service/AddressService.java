package service;

import dao.AddressDao;
import exception.ConfigurationException;
import exception.DatabaseException;
import model.Address;

/**
 * <p>
 * Address detail service class which has methods for adding,address details.
 * It contain all the business logic operation of address detail class.
 * </p> 
 * 
 * @author Madhan
 *
 */
public class AddressService {
	
	private AddressDao addressDao = new AddressDao();
	
	/**
     * Call loan detail dao for add new loan detail.
     * 
	 * @param address
     *     Get address detail object from controller. 
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.      
	 */
	public void addAddress(Address address) throws DatabaseException, ConfigurationException {
		addressDao.insertAddress(address);
	}
}
package service;

import java.util.List;

import dao.AddressDao;
import exception.ConfigurationException;
import exception.DatabaseException;
import model.Address;
import model.LoanDetail;

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
     * Call address detail dao for add new address detail.
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
	
	/**
     * Call address detail dao for add new address detail.
     * 
	 * @param address
     *     Get address detail object from controller. 
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public Address retrieveAddressByUserId(int userId) throws DatabaseException, ConfigurationException {
    	int sizeCount = 1;
    	List<Address> addresses = addressDao.retrieveAddressesByUserId(userId);
    	int listSize = addresses.size();
        for (Address address : addresses) {
        	if (listSize == sizeCount) {
        		return address;
        	} else {
        		sizeCount++;
        	}
        }
        return null; 		
	}	
}
package service;

import dao.AddressDao;
import exception.ApplicationException;
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
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public void addAddress(Address address) throws ApplicationException {
		addressDao.insertAddress(address);
	}
}
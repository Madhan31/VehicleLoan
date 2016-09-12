package service;

import dao.AddressDao;
import exception.ApplicationException;
import model.Address;

/**
 * 
 * @author Madhan
 *
 */
public class AddressService {
	
	private AddressDao addressDao = new AddressDao();
	
	public void addAddress(Address address) throws ApplicationException {
		addressDao.insertAddress(address);
	}

}

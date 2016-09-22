package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.dao.UserDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.User;
import com.i2i.vehicleloan.util.ValidationUtil;

/**
 * <p>
 * User service class which has methods for adding, removing, retrieve company details.
 * It contain all the business logic operation of company class.
 * </p> 
 * 
 * @author vicky
 *
 * @since 2016-09-06
 */
public class UserService {
	
    private UserDao userDao = new UserDao();
    
    /**
     * Call user dao for add new user detail.
     * 
     * @param user
     *     get user object from controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    public void addUser(User user) throws DatabaseException, ConfigurationException {
    	if (ValidationUtil.isAlphabetic(user.getFirstName())) {
    		if (ValidationUtil.isAlphabetic(user.getLastName())) {   	
    			if (ValidationUtil.isTenDigit(String.valueOf(user.getMobileNumber()))) {
    				if (ValidationUtil.isValidMailId(user.getEmailId())) {
                        userDao.addUser(user);
    		        }
    		        throw new DatabaseException("Mobile number should consist of ten numbers");
    		    }
    		    throw new DatabaseException("Email id should consist example@gmail.com");
    	    }
    	    throw new DatabaseException("Please enter alphabets only in last name");
        }
    	throw new DatabaseException("Please enter alphabets only in first name");
    }
    /**
     * Call user detail dao for retrieve particular user detail.
     * 
     * @param userId
     *     Get loan id from controller to retrieve particular user detail.
     * @return
	 *     It return the user object to controller.   
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.  
     */
    public User retrieveUser(int userId) throws DatabaseException, ConfigurationException {
    	if (ValidationUtil.isNumeric(String.valueOf(userId))) {
           return userDao.retrieveUser(userId);
        }
    	throw new DatabaseException("Please enter number only in price");
    }
    
    /**
     * Call user detail dao for retrieve all user detail.
     * 
     * @param userId
     *     Get loan id from controller to retrieve particular user detail.
     * @return
	 *     It return the user object to controller.   
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<User> retrieveAllUsers() throws DatabaseException, ConfigurationException {
        return userDao.retrieveAllUsers();
    }    
}
    

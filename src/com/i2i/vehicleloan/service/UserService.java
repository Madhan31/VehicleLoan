package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.dao.UserDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.User;

/**
 * <p>
 * User service class which has methods for adding, removing, retrieve company details.
 * It contain all the business logic operation of company class.
 * </p> 
 * 
 * @author vicky
 *
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
        userDao.addUser(user);
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
        return userDao.retrieveUser(userId);
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
    

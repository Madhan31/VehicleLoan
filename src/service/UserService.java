package service;

import java.util.List;

import dao.UserDao;
import exception.ApplicationException;
import model.User;

/**
 * 
 * @author vicky
 *
 */
public class UserService {
	
    private UserDao userDao = new UserDao();
    
    /**
     * 
     * @param user
     * @throws ApplicationException
     */
    public void addUser(User user) throws ApplicationException {
        userDao.addUser(user);
    }
    
    /**
     * 
     * @param userId
     * @return
     * @throws ApplicationException
     */
    public User retrieveUser(int userId) throws ApplicationException{
        return userDao.retrieveUser(userId);
    }
    
    /**
     * 
     * @param mobileNumber
     * @return
     * @throws ApplicationException
     */
    public int getUserId(long mobileNumber) throws ApplicationException {
    	List<User> user = userDao.retrieveUserByMobileNumber(mobileNumber);
        return ((User) user).getUserId();
    }
}
    

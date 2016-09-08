package service;

import java.util.List;

import dao.UserDao;
import exception.ApplicationException;
import model.User;

public class UserService {
    private UserDao userDao = new UserDao();
    
    public void addUser(User user) throws ApplicationException {
        userDao.addUser(user);
    }
    
    public User retrieveUser(int userId) throws ApplicationException{
        return userDao.retrieveUser(userId);
    }
    
    public int getUserId(long mobileNumber) throws ApplicationException {
    	List<User> user = userDao.retrieveUserByMobileNumber(mobileNumber);
    	System.out.println(user);
        return ((User) user).getUserId();
    }
}
    

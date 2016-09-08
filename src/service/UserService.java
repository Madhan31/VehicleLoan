package service;

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
    
    public int getUserId(String mobileNumber) throws ApplicationException {
    	User user = userDao.retrieveUserByMobileNumber(mobileNumber);
        return user.getUserId();
    }
}
    

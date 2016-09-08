package service;

import dao.UserDao;
import exception.ApplicationException;
import model.User;

public class UserService {
    private UserDao userDao = new UserDao();
    
    public void addUser(User user) throws ApplicationException {
        userDao.addUser(user);
    }
    
    public User retrieveUser(int mobileNumber) throws ApplicationException{
        return userDao.retrieveUser(mobileNumber);
    }
    
    public int getUserId(User user) throws ApplicationException {
        return user.getUserId();
    }
}
    

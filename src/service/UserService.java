package service;

import dao.UserDao;
import exception.ApplicationException;
import model.User;

public class UserService {
    private UserDao userDao = new UserDao();
    
    public void addUser(User user) throws ApplicationException {
        userDao.addUser(user);
    }
    
    public User retrieveUser(int phoneNumber) throws ApplicationException{
        return userDao.retrieveUser(phoneNumber);
    }
    
    public int getUserId(User user) throws ApplicationException {
        return user.getUserId();
    }
}
    

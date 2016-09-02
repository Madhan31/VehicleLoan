package service;

import dao.userDao;

public class UserService {
    private UserDao userDao = new UserDao();
    
    public void addUser(User user) throws ApplicationException {
        userDao.addUser(user);
    }
    
    public User retrieveUser(String phoneNumber) throws ApplicationException{
        return userDao.retrieveUser(phoneNumber);
    }
}
    

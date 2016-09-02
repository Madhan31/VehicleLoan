package dao;

import model.User;

public class UserDao {
    private HibernateConnection hibernateConnection = HibernateConnection.getConnection();
    private SessionFactory sessionFactory = hibernateConnection.getSessionFactory();
    
    public void addUser(User user) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch(Hibernatexception e) {
            throw new ApplicationException("Error occured in add the values in account", e);
        } finally {
            session.close();
        }
    }
    
    public User retrieveUser(String phoneNumber) throws ApplicationException {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        User user;
        try {
            transaction = session.beginTransaction();
            user = (User) session.get(User.class, phoneNumber);
            transaction.commit();
            return user;
        } catch(HibernateException e) {
            throw new ApplicationException("Error occured in retrive the account details in account", e);
        } finally {
            session.close();
        }
    } 
    
    

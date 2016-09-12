package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Address;

/**
 * 
 * @author Madhan
 *
 */
public class AddressDao {
	
	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
	public void insertAddress(Address address) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException exp) {
            transaction.rollback();
            exp.printStackTrace();
            throw new ApplicationException("Oops...Cannot add address kindly check your input and try again...\n", exp);    
        } finally {
            session.close();           
        }		
	}

}

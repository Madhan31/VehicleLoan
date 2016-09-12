package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Address;

/**
 * Dao class which has methods for adding address details in database.
 * 
 * @author Madhan
 *
 */
public class AddressDao {
	
	private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
	private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
    /**
     * To add the address detail into database by using session.
     * 
     * @param address
     *     Its object from service method.It contains the adddress detail of user.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
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

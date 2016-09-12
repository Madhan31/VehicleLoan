package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Company;

/**
 * Dao class which has methods for adding, retrieve, remove company details in database.
 * 
 * @author vicky
 *
 */
public class CompanyDao {

    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
    /**
     * Retrieve all company details from database and returns to service method. 
     * 
     * @return
     * 		Returns company list to service method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Company> retrieveCompanies() throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<Company> companies = session.createQuery("from Company").list();
            transaction.commit();
            return companies;
        } catch (HibernateException exp) {
            throw new ApplicationException("Oops...Cant retrieve companies Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }
    }	
    
    /**
     * To add the company detail into database by using session.
     * 
     * @param company
     *     Its object from service method.It contains company detail.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addCompany(Company company) throws ApplicationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in add the values in company", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the company detail from database by using the company id.
     * 
     * @param companyId
     *     Get company id from service to fetch the particular comapny detail want to remove. 
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void removeCompany(int companyId) throws ApplicationException {
        session = sessionFactory.openSession();
        Company company;
        try {
            transaction = session.beginTransaction();  
            company = (Company) session.load(Company.class, companyId);
            session.delete(company);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new ApplicationException("Error occured in remove the vehicle details in company", exp);
        } finally {
            session.close();
        }
    }	
}

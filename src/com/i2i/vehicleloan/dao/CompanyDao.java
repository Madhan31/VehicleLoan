package com.i2i.vehicleloan.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.i2i.vehicleloan.connection.HibernateConnection;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Company;

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
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public List<Company> retrieveCompanies() throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            List<Company> companies = session.createQuery("from Company").list();
            transaction.commit();
            return companies;
        } catch (HibernateException exp) {
            throw new DatabaseException("Oops...Cant retrieve companies Kindly check your input and try again...\n", exp);
        } finally {
            session.close();
        }
    }	
    
    /**
     * To add the company detail into database by using session.
     * 
     * @param company
     *     Its object from service method.It contains company detail.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void addCompany(Company company) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new DatabaseException("Error occured in add the values in company", exp);
        } finally {
            session.close();
        }
    }
    
    /**
     * To remove the company detail from database by using the company id.
     * 
     * @param companyId
     *     Get company id from service to fetch the particular comapny detail want to remove. 
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.
     */
    public void removeCompany(int companyId) throws DatabaseException, ConfigurationException {
        session = sessionFactory.openSession();
        Company company;
        try {
            transaction = session.beginTransaction();  
            company = (Company) session.load(Company.class, companyId);
            session.delete(company);
            transaction.commit();
        } catch(HibernateException exp) {
            throw new DatabaseException("Error occured in remove the vehicle details in company", exp);
        } finally {
            session.close();
        }
    }	
}

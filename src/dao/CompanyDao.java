package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import connection.HibernateConnection;
import exception.ApplicationException;
import model.Company;

public class CompanyDao {

    private HibernateConnection hibernateConnection =  HibernateConnection.createObject();
    private SessionFactory sessionFactory = hibernateConnection.establishConnection();
    private Session session;
    private Transaction transaction;	
	
    /**
     * <p>
     * Retrieve all companies from database and returns to service method. 
     * </p>
     * @return
     * 		Returns company list to service method.
     * @throws DatabaseException
     * 		if there is any error in hibernate configuration.
     */
    public List<Company> retrieveCompanys() throws ApplicationException {
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

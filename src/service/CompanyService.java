package service;

import java.util.List;

import dao.CompanyDao;
import exception.ConfigurationException;
import exception.DatabaseException;
import model.Company;

/**
 * <p>
 * Company service class which has methods for adding, removing, retrieve company details.
 * It contain all the business logic operation of company class.
 * </p>
 *    
 * @author vicky
 *
 */
public class CompanyService {

    private CompanyDao comanyDao = new CompanyDao();
	
    /**
     * Retrieve all the company details from database to controller method
     * 
     * @return 
     *     It returns list object to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    public List<Company> retrieveCompanies() throws DatabaseException, ConfigurationException {
        return comanyDao.retrieveCompanies();		
    }	
    
    /**
     * Call company dao for add the new company detail.
     * 
     * @param company
     *     Its object from a controller
     * @return 
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    public String addCompany(Company company) throws DatabaseException, ConfigurationException {
        comanyDao.addCompany(company);
        return "Company details added successfully";
    }
    
    /**
     * Call company dao for remove the company detail.
     * 
     * @param companyId
     *     Get company id from controller.
     * @return 
     *     Its return notification message to controller.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
     */
    public String removeCompany(int companyId) throws DatabaseException, ConfigurationException {
        comanyDao.removeCompany(companyId);
        return "Company details deleted successfully";
    }    
}

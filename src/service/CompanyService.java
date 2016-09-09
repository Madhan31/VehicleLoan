package service;

import java.util.List;

import dao.CompanyDao;
import exception.ApplicationException;
import model.Company;

/**
 * 
 * @author vicky
 *
 */
public class CompanyService {

    private CompanyDao comanyDao = new CompanyDao();
	
    /**
     * 
     * @return
     * @throws ApplicationException
     */
    public List<Company> retrieveCompanies() throws ApplicationException {
        return comanyDao.retrieveCompanies();		
    }	
    
    /**
     * 
     * @param company
     * @return
     * @throws ApplicationException
     */
    public String addCompany(Company company) throws ApplicationException {
        comanyDao.addCompany(company);
        return "Company details added successfully";
    }
    
    /**
     * 
     * @param companyId
     * @return
     * @throws ApplicationException
     */
    public String removeCompany(int companyId) throws ApplicationException {
        comanyDao.removeCompany(companyId);
        return "Company details deleted successfully";
    }    
}

package service;

import java.util.List;

import dao.CompanyDao;
import exception.ApplicationException;
import model.Company;

public class CompanyService {

    private CompanyDao comanyDao = new CompanyDao();
	
    public List<Company> retrieveCompanys() throws ApplicationException {
        return comanyDao.retrieveCompanys();		
    }	

    public String addCompany(Company company) throws ApplicationException {
        comanyDao.addCompany(company);
        return "Company details added successfully";
    }
    
    public String removeCompany(int companyId) throws ApplicationException {
        comanyDao.removeCompany(companyId);
        return "Company details deleted successfully";
    }    
}

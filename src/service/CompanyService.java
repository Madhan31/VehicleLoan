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

}

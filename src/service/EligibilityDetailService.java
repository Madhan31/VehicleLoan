package service;

import dao.EligibilityDetailDao;
import exception.DatabaseException;
import model.Employee;

public class EligibilityDetailService {
	
	private EligibilityDetailDao eligibilityDetailDao = new EligibilityDetailDao();
	
    /**
	 * <p>
	 * Calls eligibility dao methods to add eligibility details.
	 * </p> 
     * @param employee
     * 		Its a object from controller method
     * @return
     * 		Returns true or false to controller method.
     * @throws DatabaseException
     * 		If there is any error in hibernate configuration.
     */   
    public boolean addEligibilityDetail(EligibilityDetail eligibilityDetail) throws ApplicationException {
        return eligibilityDetailDao.insertEmployee(eligibilityDetail);
    }	

}
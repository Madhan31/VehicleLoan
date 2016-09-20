package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.dao.EligibilityDetailDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.EligibilityDetail;

/**
 * <p>
 * Eligibility detail service class which has methods for adding eligibility details.
 * It contain all the business logic operation of eligibility detail class.
 * </p>  
 * 
 * @author Madhan
 *
 * @since 2016-09-06
 */
public class EligibilityDetailService {
	
	private EligibilityDetailDao eligibilityDetailDao = new EligibilityDetailDao();
	
    /**
	 * Calls eligibility dao methods to add eligibility details.
	 *  
     * @param employee
     * 		Its a object from controller method
     * @return
     * 		Returns true or false to controller method.
     * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.   
     */   
    public boolean addEligibilityDetail(EligibilityDetail eligibilityDetail) throws DatabaseException, ConfigurationException {
        if (eligibilityDetail.getSalary() < 10000) {
            throw new DatabaseException("Salary must be greater than 10000");
        }
        if (null == eligibilityDetail.getCompany()) {
            throw new DatabaseException("Kindly select the company name");
        }
        if (null == eligibilityDetail.getVehicleModel()) {
            throw new DatabaseException("Kindly select the vehicle model");
        }    
        if (eligibilityDetail.getDownPayment() < 10000) {
            throw new DatabaseException("Downpayment must be greater than 10000");
        }
        return eligibilityDetailDao.insertEligibilityDetail(eligibilityDetail);
    }
    
    /**
	 * Calls eligibility dao methods to retrieve eligibility details.
	 *  
     * @param employee
     * 		Its a object from controller method
     * @return
     * 		Returns true or false to controller method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */   
    public List<EligibilityDetail> retrieveEligibilityDetailsByUserId(int userId) throws DatabaseException, ConfigurationException {
        return eligibilityDetailDao.retrieveEligibilityDetailsByUserId(userId);
    }    
}

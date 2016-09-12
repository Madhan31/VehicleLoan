package service;

import java.util.List;

import dao.LoanDetailDao;
import exception.ApplicationException;
import model.LoanDetail;

/**
 * <p>
 * Loan deatil service class which has methods for adding, retrieve loan detail details.
 * It contain all the business logic operation of loan detail class.
 * </p> 
 * 
 *  @author vicky
 *
 */
public class LoanDetailService {
    private LoanDetailDao loanDetailDao = new LoanDetailDao();
    
    /**
     * Call loan detail dao for add new loan detail.
     * 
     * @param loanDetail
     *     Get loan detail object from controller. 
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoanDetail(LoanDetail loanDetail) throws ApplicationException {
    	loanDetailDao.addLoanDetail(loanDetail);
    }
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id form controller for retrieve particular loan detail.
     * @return
     *     Return the object of retrieve exist loan detail to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public LoanDetail retrieveLoanDetailByLoanId(int loanId) throws ApplicationException {
    	int sizeCount = 1;
    	int listSize = loanDetailDao.retrieveLoanDetailsByLoanId(loanId).size();
        for (LoanDetail loanDetail :loanDetailDao.retrieveLoanDetailsByLoanId(loanId)) {
        	if (listSize == sizeCount) {
        		return loanDetail;
        	} else {
        		sizeCount++;
        	}
        }
        return null;
    }	  
    
    /**
     * Retrieve all the company details from database to controller method.
     *   
     * @param userId
     *     Get the userId from controller.
     * @return
     *     It return list of object to controller method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId)throws ApplicationException {
    	return loanDetailDao.retrieveLoanDetailByUserId(userId);
    }
}

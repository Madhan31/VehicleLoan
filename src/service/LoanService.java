package service;

import java.util.List;

import dao.LoanDao;
import exception.ApplicationException;
import model.EligibilityDetail;
import model.Loan;
import model.VehicleModel;

/**
 * <p>
 * Loan service class which has methods for adding, retrieve loan details.
 * It contain all the business logic operation of loan class.
 * </p> 
 * 
 * @author admin-pc
 *
 */
public class LoanService {
    private LoanDao loanDao = new LoanDao();
    
    /**
     * Call loan dao for add new loan detail.
     * 
     * @param loan
     *     Get loan object from controller. 
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public void addLoan(Loan loan) throws ApplicationException {
        loanDao.addLoan(loan);
    }
    
    /**
     * Call loan detail dao for remove loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public String removeLoan(int loanId) throws ApplicationException {
        if (isLoanExist(loanId)) {
            loanDao.removeLoan(loanId); 
            return "Loan deleted successfully"; 
        }
        return "Loan not exist";
    }
    
    /**
     * Call loan detail dao for retrieve particular loan detail.
     * 
     * @param loanId
     *     Get loan id from controller.
     * @return
     *    It return notification message to controller.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public Loan retrieveLoan(int loanId) throws ApplicationException {
        return loanDao.retrieveLoan(loanId);
    }
    
    /**
     * Retrieve all the loan from database to controller method.
     * 
     * @param userId
     *     Get the userId from controller.
     * @return
     *     It return list of object to controller method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Loan> retrieveLoansByUserId(int userId) throws ApplicationException {
        return loanDao.retrieveLoansByUserId(userId);
    }
    
    /**
     * Retrieve all the loan from database to controller method.
     * 
     * @return
     *     It return list of object to controller method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public List<Loan> retreiveAllLoans() throws ApplicationException {
        return loanDao.retreieveAllLoans();
    }
    
    /**
     * Check whether the loan detail exist or not.
     * 
     * @param loanId
     *     Get the loan id from controller.
     * @return
     *     It return true or false to service method.
     * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
     */
    public boolean isLoanExist(int loanId) throws ApplicationException {
        return (retrieveLoan(loanId) != null);
    }
    
    /**
     * Here calculate the loan amount user want from the down payment.
     * 
     * @param eligibilityDetail
     *     Get the eligibility object from controller.
     * @param vehicleModel
     *     Get the vehicle model object from controller.
     * @return
     *     It return the value to controller.
     */
    public int calculateLoanAmount(EligibilityDetail eligibilityDetail,VehicleModel vehicleModel) {
    	return (vehicleModel.getPrice() - eligibilityDetail.getDownPayment());
    }
    
    /**
     * Here calculate the emi amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    public float getEmiDetails(int loanPeriod,int loanAmount) {
    	if(loanPeriod == 12) {
    		return (loanAmount + loanAmount * 10/100)/loanPeriod;
    	}
    	if(loanPeriod == 24) {
    		return (loanAmount + loanAmount * 15/100)/loanPeriod;
    	}
    	if(loanPeriod == 36) {
    		return (loanAmount + loanAmount * 18/100)/loanPeriod;
    	}
    	return 0;    	
    }
    
    /**
     * Here calculate the processing fees amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    public float getProcessingFees(int loanPeriod,int loanAmount) {
    	if(loanPeriod == 12) {
    		return (loanAmount * 2/100);
    	}
    	if(loanPeriod == 24) {
    		return (loanAmount * 3/100);
    	}
    	if(loanPeriod == 36) {
    		return (loanAmount * 4/100);
    	}
    	return 0;    	
    }
    
    /**
     * Here calculate the documentation charge amount based on user selected emi period.
     * 
     * @param loanPeriod
     *     Get the loan period from cotroller.
     * @param loanAmount
     *     Get the loan amount from cotroller.
     * @return
     *     It return the value to controller.
     */
    public float getDocumentationCharges(int loanPeriod,int loanAmount) {
    	if(loanPeriod == 12) {
    		return (loanAmount * 5/100);
    	}
    	if(loanPeriod == 24) {
    		return (loanAmount * 4/100);
    	}
    	if(loanPeriod == 36) {
    		return (loanAmount * 3/100);
    	}
    	return 0;     	
    }    
}

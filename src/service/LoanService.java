package service;

import java.util.List;

import dao.LoanDao;
import exception.ApplicationException;
import model.EligibilityDetail;
import model.Loan;
import model.VehicleModel;

public class LoanService {
    private LoanDao loanDao = new LoanDao();
    
    public void addLoan(Loan loan) throws ApplicationException {
        loanDao.addLoan(loan);
    }
    
    public String removeLoan(int loanId) throws ApplicationException {
        if (isLoanExist(loanId)) {
            loanDao.removeLoan(loanId); 
            return "Loan deleted successfully"; 
        }
        return "Loan not exist";
    }
    
    public Loan retrieveLoan(int loanId) throws ApplicationException {
        return loanDao.retrieveLoan(loanId);
    }
    
    public List<Loan> retreiveAllLoans() throws ApplicationException {
        return loanDao.retreieveAllLoans();
    }
    
    public boolean isLoanExist(int loanId) throws ApplicationException {
        return (retrieveLoan(loanId) != null);
    }
    
    public int calculateLoanAmount(EligibilityDetail eligibilityDetail,VehicleModel vehicleModel) {
    	return (vehicleModel.getPrice() - eligibilityDetail.getDownPayment());
    }
    
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

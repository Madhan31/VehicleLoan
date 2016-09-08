package service;

import java.util.List;

import dao.LoanDao;
import exception.ApplicationException;
import model.EligibilityDetail;
import model.Loan;

public class LoanService {
    private LoanDao loanDao = new LoanDao();
    
    public int calculateLoanAmount(EligibilityDetail eligibilityDetail) {
    	System.out.println(eligibilityDetail.getVehicleModel().getPrice());
    	return (eligibilityDetail.getVehicleModel().getPrice() - eligibilityDetail.getDownPayment());
    }
    
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
}


package service;

import dao.LoanDetailDao;
import exception.ApplicationException;
import model.LoanDetail;

public class LoanDetailService {
    private LoanDetailDao loanDetailDao = new LoanDetailDao();
    
    public void addLoanDetail(LoanDetail loanDetail) throws ApplicationException {
    	loanDetailDao.addLoanDetail(loanDetail);
    }
    
    public LoanDetail retrieveLoanDetail(int loanId) throws ApplicationException {
        return loanDetailDao.retrieveLoanDetail(loanId);
    }
    
    public boolean isLoanDetailExist(int loanId) throws ApplicationException {
        return (retrieveLoanDetail(loanId) == null);
    }
}

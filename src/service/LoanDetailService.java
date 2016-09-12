package service;

import java.util.List;

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
    
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId)throws ApplicationException {
    	return loanDetailDao.retrieveLoanDetailByUserId(userId);
    }
    
    public boolean isLoanDetailExist(int loanId) throws ApplicationException {
        return (retrieveLoanDetail(loanId) == null);
    }
}

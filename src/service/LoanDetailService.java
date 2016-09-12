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
        return isLoanDetailExist(loanId);
    }
    
    public LoanDetail isLoanDetailExist(int loanId) throws ApplicationException {
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
    
    public List<LoanDetail> retrieveLoanDetailByUserId(int userId)throws ApplicationException {
    	return loanDetailDao.retrieveLoanDetailByUserId(userId);
    }
}

package service;

import model.Loan;
import model.Payment;

import dao.PaymentDao;
import exception.ApplicationException;

public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	private LoanService loanService = new LoanService();
	
	public String addPayment(Payment payment) throws ApplicationException {
        paymentDao.addPayment(payment);
        Loan loan = loanService.retrieveLoan(payment.getLoan().getLoanId());
        if(loanDetailService.retrieveLoanDetail(payment.getLoan().getLoanId())) {
           int balancePeriod = loan.getLoanPeriod();
           int balanceAmount = loan.getLoanAmount();
           LoanDetail loandetail = new LoanDetail(balanceAmount, balanceEmi);
        }
        return "Successfully paided";
    }
	
	public Payment retrievePayment(int paymentId) throws ApplicationException {
        return paymentDao.retrievePayment(paymentId);
    }
}

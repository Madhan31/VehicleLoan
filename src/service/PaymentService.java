package service;

import model.Loan;
import model.LoanDetail;
import model.Payment;

import dao.PaymentDao;
import exception.ApplicationException;

public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	private LoanService loanService = new LoanService();
	private LoanDetailService loanDetailService = new LoanDetailService();
	
	public String addPayment(Payment payment) throws ApplicationException {
        paymentDao.addPayment(payment);
        Loan loan = loanService.retrieveLoan(payment.getLoan().getLoanId());
        System.out.println(loan.getLoanId());
        if(loanDetailService.isLoanDetailExist(payment.getLoan().getLoanId())) {
            System.out.println("test11");
            int balanceEmi = ((loan.getLoanPeriod()) - 1);
            int balanceAmount = (loan.getLoanAmount() - payment.getPaymentAmount());
            loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment));
            return "Successfully paided";
        }
        System.out.println("test22");
        LoanDetail loanDetail = loanDetailService.retrieveLoanDetail(payment.getLoan().getLoanId());
        int balanceEmi = (loanDetail.getBalanceEmi() - 1);
        int balanceAmount = (loanDetail.getBalanceAmount() - payment.getPaymentAmount());
        loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment));
        return "Successfully paided";
    }
	
	public Payment retrievePayment(int paymentId) throws ApplicationException {
        return paymentDao.retrievePayment(paymentId);
    }
}

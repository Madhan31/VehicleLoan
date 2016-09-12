package service;

import model.Loan;
import model.LoanDetail;
import model.Payment;

import dao.PaymentDao;
import exception.ApplicationException;

/**
 * <p>
 * Payment service class which has methods for adding, retrieve payment details.
 * It contain all the business logic operation of payment class.
 * </p> 
 * 
 * @author admin-pc
 *
 */
public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	private LoanService loanService = new LoanService();
	private LoanDetailService loanDetailService = new LoanDetailService();
	
	/**
     * Call payment dao for add new payment detail.
     * 
	 * @param payment
	 *     Get the payment object from controller.
	 * @return
     *     Its return notification message to controller.
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public String addPayment(Payment payment) throws ApplicationException {
        paymentDao.addPayment(payment);
        Loan loan = loanService.retrieveLoan(payment.getLoan().getLoanId());
        if(null == loanDetailService.retrieveLoanDetailByLoanId(payment.getLoan().getLoanId())) {
            int balanceEmi = ((loan.getLoanPeriod()) - 1);
            int balanceAmount = (loan.getLoanAmount() - payment.getPaymentAmount());
            loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment, loan.getUser()));
            return "Successfully paided";
        }
        LoanDetail loanDetail = loanDetailService.retrieveLoanDetailByLoanId(payment.getLoan().getLoanId());
        int balanceEmi = (loanDetail.getBalanceEmi() - 1);
        int balanceAmount = (loanDetail.getBalanceAmount() - payment.getPaymentAmount());
        loanDetailService.addLoanDetail(new LoanDetail(balanceAmount, balanceEmi, loan, payment, loan.getUser()));
        return "Successfully paided";
    }
	
	/**
     * Call loan detail dao for retrieve particular loan detail.
     * 
	 * @param paymentId
	 *     Get payment id from controller for retrieve particular payment detail.
	 * @return
	 *     It return the payment object to controller.   
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public Payment retrievePayment(int paymentId) throws ApplicationException {
        return paymentDao.retrievePayment(paymentId);
    }
}

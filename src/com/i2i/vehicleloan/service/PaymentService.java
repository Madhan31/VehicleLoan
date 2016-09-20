package com.i2i.vehicleloan.service;

import java.util.List;

import com.i2i.vehicleloan.dao.PaymentDao;
import com.i2i.vehicleloan.exception.ConfigurationException;
import com.i2i.vehicleloan.exception.DatabaseException;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.LoanDetail;
import com.i2i.vehicleloan.model.Payment;

/**
 * <p>
 * Payment service class which has methods for adding, retrieve payment details.
 * It contain all the business logic operation of payment class.
 * </p> 
 * 
 * @author admin-pc
 *
 * @since 2016-09-06
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
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.    
	 */
	public String addPayment(Payment payment) throws DatabaseException, ConfigurationException {
        paymentDao.addPayment(payment);
        Loan loan = loanService.retrieveLoan(payment.getLoan().getLoanId());
        if (null == loanDetailService.retrieveLoanDetailByLoanId(payment.getLoan().getLoanId())) {
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
	 * @throws DatabaseException
     *     It handle all the custom exception in vehicle loan application.
     * @throws ConfigurationException
     *     It handle all the error message in configuration file.     
	 */
	public Payment retrievePayment(int paymentId) throws DatabaseException, ConfigurationException {
        return paymentDao.retrievePayment(paymentId);
    }
	
	/**
     * Call payment dao for retrieve particular payment detail.
     * 
	 * @return
	 *     It return the payment object to controller.   
	 * @throws ApplicationException
     *     It handle all the custom exception in vehicle loan application.
	 */
	public List<Payment> retrievePaymentsByLoanId(int loanId) throws DatabaseException, ConfigurationException {
        return paymentDao.retrievePaymentsByLoanId(loanId);
    }	
}

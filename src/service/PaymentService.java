package service;

import model.Payment;

import dao.PaymentDao;
import exception.ApplicationException;

public class PaymentService {
	private PaymentDao paymentDao = new PaymentDao();
	
	public String addPayment(Payment payment) throws ApplicationException {
        paymentDao.addPayment(payment);
        return "Successfully paided";
    }
	
	public Payment retrievePayment(int paymentId) throws ApplicationException {
        return paymentDao.retrievePayment(paymentId);
    }
}

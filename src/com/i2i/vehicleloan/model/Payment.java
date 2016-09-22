/**
 * 
 */
package com.i2i.vehicleloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Payment pojo class which has setter and getter methods for accessing payment details.
 * 
 * @author Madhan
 *
 */
@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "payment_id")
	private int paymentId;
	
	@Column(name = "payment_amount")
	private int paymentAmount;
	
	@Column(name = "date")
	private String date;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "loan_id")
    private Loan loan;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
  
    /**
     * Constructor with argument is used to create a payment object.
     * 
     * @param paymentId
     *     Contains unique id for an user payment amount.
     * @param paymentAmount
     *     Contains payment amount of customer at the time installment period. 
     * @param date
     *     Contains date of payment of a customer.
     * @param loan
     *     Contains loan object of class loan.
     * @param user
     *     Contains user object of class user.
     */
    public Payment(int paymentId, int paymentAmount, String date, Loan loan, User user) {
        super();
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.date = date;
        this.loan = loan;
        this.user = user;
    }
    
    /**
     * Constructor without argument is used to create an object. 
     */
    public Payment() {
        
    }    
    
	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
	/**
	 *Return object to string format. 
	 */
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", date=" + date + ", loan="
				+ loan + "]";
	}
}

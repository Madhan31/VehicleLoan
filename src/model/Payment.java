/**
 * 
 */
package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Madhan
 *
 */
@Entity
@Table(name = "payment")
public class Payment {
	
	/**
	 * @param paymentId
	 * @param paymentAmount
	 * @param date
	 * @param loan
	 * @param user
	 */
	public Payment(int paymentId, int paymentAmount, String date, Loan loan, User user) {
		super();
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.date = date;
		this.loan = loan;
		this.user = user;
	}
    public Payment() {
    	
    }
	@Id
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
	 * 
	 */
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", date=" + date + ", loan="
				+ loan + "]";
	}
}

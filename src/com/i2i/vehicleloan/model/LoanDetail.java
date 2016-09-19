package com.i2i.vehicleloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.i2i.vehicleloan.model.Payment;

/**
 * Loan detail pojo class which has setter and getter methods for accessing loan detail details.
 * 
 * @author vicky
 *
 */
@Entity
@Table(name = "loan_detail")
public class LoanDetail {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "loan_detail_id",  unique = true)
    private int loanDetailId;
    
    @Column(name = "balance_loan_amount")
    private int balanceAmount;
    
    @Column(name = "balance_emi_months")
    private int balanceEmi;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "loan_id")
    private Loan loan;    
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;    
    
    /**
     * Constructor without argument is used to create loan detail object.
     */
    public LoanDetail() {
    }
    
    /**
     * Constructor with argument is used to create loan detail object.
     * 
     * @param balanceAmount
     *     Contains balance amount of customer to be paided.
     * @param balanceEmi
     *     Contains remaining number of installent period.
     * @param loan
     *     Contains loan object of an class loan.
     * @param payment
     *     Contains payment object of an class payment.
     */
    public LoanDetail(int balanceAmount, int balanceEmi, Loan loan, Payment payment, User user) {
    	this.payment = payment;
    	this.loan = loan;
        this.balanceAmount = balanceAmount;
        this.balanceEmi = balanceEmi;
        this.user = user;
    }
    
    /**
     * Constructor with argument is used to create loan detail object.
	 * @param balanceAmount
     *     Contains balance amount of customer to be paided.
     * @param balanceEmi
     *     Contains remaining number of installment period.
     * @param loan
     *     Contains loan object of an class loan.
     * @param payment
     *     Contains payment object of an class payment.
	 */
	public LoanDetail(int balanceAmount, int balanceEmi, User user) {
		this.balanceAmount = balanceAmount;
		this.balanceEmi = balanceEmi;
		this.user = user;
	}

	public int getLoanDetailId() {
        return loanDetailId;
    }
   
    public int getBalanceAmount() {
        return balanceAmount;
    }
   
    public int getBalanceEmi() {
        return balanceEmi;
    }
   
    public Payment getPayment() {
        return payment;
    }
   
    public void setLoanDetailId(int loanDetailId) {
        this.loanDetailId = loanDetailId;
    }
    
   /**
    * Return object into string format
    */
    @Override
	public String toString() {
		return "LoanDetail [loanDetailId=" + loanDetailId + ", balanceAmount=" + balanceAmount + ", balanceEmi="
				+ balanceEmi + ", loan=" + loan + ", payment=" + payment + "]";
	}

	public void setLoanName(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    
    public void setBalanceEmi(int balanceEmi) {
        this.balanceEmi = balanceEmi;
    }
   
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public void setBalanceAmount(int balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
}
   

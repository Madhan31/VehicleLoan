package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Payment;

@Entity
@Table(name = "loan_detail")
public class LoanDetail {
    
    @Id
    @Column(name = "loan_detail_id",  unique = true)
    private int loanDetailId;
    
    @Column(name = "balance__loan_amount")
    private int balanceAmount;
    
    @Column(name = "balance_emi_months")
    private int balanceEmi;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "loan_id")
    private Loan loan;    
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    private Payment payment;
    
    public LoanDetail() {
    }
   
    public LoanDetail(int loanDetailId, int balanceAmount, int balanceEmi) {
        this.loanDetailId = loanDetailId;
        this.balanceAmount = balanceAmount;
        this.balanceEmi = balanceEmi;
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
   

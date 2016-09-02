package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.Payment;

@Entity
@Table(name = "loan_detail")
public class LoanDetail {
    
    @Id
    @Column(name = "loan_detail_id",  unique = true)
    private int loanDetailId;
    
    @Column(name = "balance_amount")
    private int balanceAmount;
    
    @Column(name = "balance_emi")
    private int balanceEmi;
    
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
   
    public String getBalanceAmount() {
        return balanceAmount;
    }
   
    public int getBalanceEmi() {
        return balanceEmi;
    }
   
    public set getPayment() {
        return payment;
    }
   
    public void setLoanDetailId(int loanDetailId) {
        this.loanDetailId = loanDetailId;
    }
   
    public void setLoanName(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
    
    public void setBalanceEmi(int balanceEmi) {
        this.balanceEmi = balanceEmi;
    }
   
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
}
   

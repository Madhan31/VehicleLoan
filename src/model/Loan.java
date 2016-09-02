/**
 * 
 */
package Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Madhan
 *
 */
@Entity
@Table(name = "loan")
public class Loan {
	
	/**
	 * @param loanIdOneToMany
	 * @param emi
	 * @param loanPeriod
	 * @param documentCharges
	 * @param date
	 * @param eligibilityDetail
	 * @param user
	 */
	public Loan(int loanId, int emi, int loanPeriod, int documentCharges, String date,
			EligibilityDetail eligibilityDetail, User user) {
		super();
		this.loanId = loanId;
		this.emi = emi;
		this.loanPeriod = loanPeriod;
		this.documentCharges = documentCharges;
		this.date = date;
		this.eligibilityDetail = eligibilityDetail;
		this.user = user;
	}

	@Id
	@Column(name = "loan_id")
	private int loanId;
	
	@Column(name = "emi")
	private int emi;
	
	@Column(name = "loan_period")
	private int loanPeriod;
	
	@Column(name = "document_charges")
	private int documentCharges;
	
	@Column(name = "date")
	private String date;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "eligibility_detail_id")	
	private EligibilityDetail eligibilityDetail;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "payment_id")
    private Set<Payment> payments = new HashSet<Payment>();    

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getEmi() {
		return emi;
	}

	public void setEmi(int emi) {
		this.emi = emi;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public int getDocumentCharges() {
		return documentCharges;
	}

	public void setDocumentCharges(int documentCharges) {
		this.documentCharges = documentCharges;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public EligibilityDetail getEligibilityDetail() {
		return eligibilityDetail;
	}

	public void setEligibilityDetail(EligibilityDetail eligibilityDetail) {
		this.eligibilityDetail = eligibilityDetail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", emi=" + emi + ", loanPeriod=" + loanPeriod + ", documentCharges="
				+ documentCharges + ", date=" + date + ", eligibilityDetail=" + eligibilityDetail + "]";
	}	

}

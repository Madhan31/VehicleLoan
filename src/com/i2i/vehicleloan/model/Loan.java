package com.i2i.vehicleloan.model;

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
 * Company pojo class which has setter and getter methods for accessing company details.
 * 
 * @author Madhan
 *
 */
@Entity
@Table(name = "loan")
public class Loan {
	
	/**
	 * Constructor without object is used to create a loan object.
	 */
	public Loan() {	}

	@Id
	@Column(name = "loan_id")
	private int loanId;
	
	@Column(name = "emi_in_rupees")
	private float emi;
	
	@Column(name = "loan_period_in_months")
	private int loanPeriod;
	
	@Column(name = "processing_fees")
	private float processingFees;

	@Column(name = "documentation_charges")
	private float documentationCharges;

	@Column(name = "date")
	private String date;
	
	@Column(name = "loan_amount")
	private int loanAmount;
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "eligibility_detail_id")	
	private EligibilityDetail eligibilityDetail;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

	/**
	 * Constructor with argument is used to create a loan object.
	 * 
	 * @param loanId
	 *     Contains unique id for an loan.
	 * @param emi
	 *     Contains equated monthly installement amount from an loan amount.
	 * @param loanPeriod
	 *     Contains total installment period for accomplish the loan amount.
	 * @param processingFees
	 *     Contains processing fees for processing a loan document.
	 * @param documentationCharges
	 *     Contains documentation charge for applying loan
	 * @param date
	 *     Contain loan issued date to customer.
	 * @param loanAmount
	 *     Contains amount of loan given to an customer.
	 * @param eligibilityDetail
	 *     Contains eligibility detail class object.
	 * @param user
	 *     Contains user class object
	 * @param loanDetails
	 *     Contains loan detail class object.
	 */
	public Loan(int loanId, float emi, int loanPeriod, float processingFees, float documentationCharges, String date,
			int loanAmount, EligibilityDetail eligibilityDetail, User user, Set<LoanDetail> loanDetails) {
		super();
		this.loanId = loanId;
		this.emi = emi;
		this.loanPeriod = loanPeriod;
		this.processingFees = processingFees;
		this.documentationCharges = documentationCharges;
		this.date = date;
		this.loanAmount = loanAmount;
		this.eligibilityDetail = eligibilityDetail;
		this.user = user;
		this.loanDetails = loanDetails;
	}

	@OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "payment_id")
    private Set<LoanDetail> loanDetails = new HashSet<LoanDetail>();

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public float getEmi() {
		return emi;
	}

	public void setEmi(float emi) {
		this.emi = emi;
	}

	public int getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public float getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(float processingFees) {
		this.processingFees = processingFees;
	}

	public float getDocumentationCharges() {
		return documentationCharges;
	}

	public void setDocumentationCharges(float documentationCharges) {
		this.documentationCharges = documentationCharges;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
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

	public Set<LoanDetail> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(Set<LoanDetail> loanDetails) {
		this.loanDetails = loanDetails;
	}
}
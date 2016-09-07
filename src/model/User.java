package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.EligibilityDetail;
import model.Loan;
import model.Payment;
import model.Role;

/*
 * Pojo class of Account model and create getter setter method for all attributes.
 *   
 */

@Entity
@Table(name = "user_detail")
public class User {

    @Id
    private int userId;
	
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    @Column(name = "email_id")
    private String emailId;
    
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "password")
    private String password;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "eligibility_detail_id")
    private Set<EligibilityDetail> eligibilityDetails = new HashSet<EligibilityDetail>();
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_id")
    private Set<Loan> loans = new HashSet<Loan>();
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id")
    private Set<Payment> payments = new HashSet<Payment>();
    
    public User() {
    }
    
    public User(String firstName, String lastName, String mobileNumber, String emailId,String dateOfBirth, String gender, String password, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.password = password;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }
   
    public String getLastName() {
        return lastName;
    }
   
    public int getUserId() {
        return userId;
    }
    
    public String getEmailId() {
    	return emailId;
    }
    
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public String getDateOfBirth() {
    	return dateOfBirth;
    }
    
    public String getGender() {
    	return gender;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    public void setEmailId(String emailId) {
    	this.emailId = emailId;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
    	this.dateOfBirth =dateOfBirth;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRole(Role role) {
        this.role = role;
    }

	public void setEligibilityDetails(Set<EligibilityDetail> eligibilityDetails) {
		this.eligibilityDetails = eligibilityDetails;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}

	public Set<EligibilityDetail> getEligibilityDetails() {
		return eligibilityDetails;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public Set<Payment> getPayments() {
		return payments;
	} 
    
}
    
    
    

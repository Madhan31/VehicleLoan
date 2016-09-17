package com.i2i.vehicleloan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.i2i.vehicleloan.model.EligibilityDetail;
import com.i2i.vehicleloan.model.Loan;
import com.i2i.vehicleloan.model.Payment;
import com.i2i.vehicleloan.model.Role;

/*
 * User pojo class which has setter and getter methods for accessing user details.
 * 
 * @author vicky
 */
@Entity
@Table(name = "user_detail")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;
	
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "mobile_number")
    private long mobileNumber;
    
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
    
    /**
     * Constructor without argument is used to create an user object.
     */
    public User() {
    }
    
    /**
     * Constructor with argument is used to create an user object.
     * 
     * @param firstName
     *     Contains first name of the user.
     * @param lastName
     *     Contains last name of the user.
     * @param mobileNumber
     *     Contains contact mobile number of user.
     * @param emailId
     *     Contains contact mail address of user.
     * @param dateOfBirth
     *     Contains user date of birth.
     * @param gender
     *     Contains user gender information
     * @param password
     *     Contains user log in password.
     * @param userId
     *     Contains user log in unique user id.
     */
    public User(String firstName, String lastName, long mobileNumber, String emailId,String dateOfBirth, String gender, String password, int userId) {
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
    
    public long getMobileNumber() {
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
    
    public void setMobileNumber(long mobileNumber) {
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
    
	/**
	 * Return object to string format.
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", password=" + password + ", role=" + role + ", eligibilityDetails=" + eligibilityDetails
				+ ", loans=" + loans + ", payments=" + payments + "]";
	} 
}
    
    
    

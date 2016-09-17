package com.i2i.vehicleloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Company pojo class which has setter and getter methods for accessing company details.
 * 
 * @author vicky
 *
 */
@Entity
@Table(name = "company_detail")
public class Company {
	
	@Id
	@Column(name = "company_id")
	private int companyId;
	
	@Column(name = "company_name")
	private String companyName;
    
	/**
	 * Constructor with no arguments is used to create an company object.
	 */
	public Company() {
	}
	
	/**
	 * Constructor which has arguments is used to create company object.
	 * 
	 * @param companyId
	 *     Contains unique id for an company.
	 * @param companyName
	 *     Contains name of an company.
	 */
	public Company(int companyId, String companyName) {
		this.companyId = companyId;
		this.companyName = companyName;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}	
}

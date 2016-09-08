package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
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
	 * 
	 */
	public Company() {
	}
	
	/**
	 * 
	 * @param companyId
	 * @param companyName
	 */
	public Company(int companyId, String companyName) {
		super();
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

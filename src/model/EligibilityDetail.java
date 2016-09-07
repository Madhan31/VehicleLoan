package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.VehicleModel;

/**
 * @author Madhan
 *
 */
@Entity
@Table(name = "eligibility_detail")
public class EligibilityDetail {

	public EligibilityDetail() { }	
	
	@Id
	@Column(name = "eligibility_detail_id")
	private int id;
	
	@Column(name = "current_city")
	private String currentCity;
	
	@Column(name = "employment")
	private String employment;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "down_payment")
	private int downPayment;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "company_id")
	private Company company;	
	
	@OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_model_id")	
	private VehicleModel vehicleModel;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(int downPayment) {
		this.downPayment = downPayment;
	}

	public VehicleModel getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(VehicleModel vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Company getCompany() {
		return company;
	}	
	
	public void setCompany(Company company) {
		this.company = company;
	}	

	/**
	 * @param id
	 * @param currentCity
	 * @param employment
	 * @param salary
	 * @param downPayment
	 * @param company
	 * @param vehicleModel
	 * @param user
	 */
	public EligibilityDetail(int id, String currentCity, String employment, String salary, int downPayment,
			Company company, VehicleModel vehicleModel, User user) {
		super();
		this.id = id;
		this.currentCity = currentCity;
		this.employment = employment;
		this.salary = salary;
		this.downPayment = downPayment;
		this.company = company;
		this.vehicleModel = vehicleModel;
		this.user = user;
	}

	@Override
	public String toString() {
		return "EligibilityDetail [id=" + id + ", currentCity=" + currentCity + ", employment=" + employment
				+ ", company=" + company + ", salary=" + salary + ", downPayment=" + downPayment + ", vehicleModel="
				+ vehicleModel + ", user=" + user + "]";
	}
}

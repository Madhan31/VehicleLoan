package Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * @author Madhan
 *
 */
@Entity
@Table(name = "eligibility_detail")
public class EligibilityDetail {
	
	/**
	 * @param id
	 * @param currentCity
	 * @param employment
	 * @param company
	 * @param salary
	 * @param downPayment
	 * @param vehicleModel
	 * @param user
	 */
	public EligibilityDetail(int id, String currentCity, String employment, String company, String salary,
			int downPayment, VehicleModel vehicleModel, User user) {
		super();
		this.id = id;	@
		this.currentCity = currentCity;
		this.employment = employment;
		this.company = company;
		this.salary = salary;
		this.downPayment = downPayment;
		this.vehicleModel = vehicleModel;
		this.user = user;
	}

	@Id
	@Column(name = "eligibility_detail_id")
	private int id;
	
	@Column(name = "current_city")
	private String currentCity;
	
	@Column(name = "employment")
	private String employment;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "down_payment")
	private int downPayment;
	
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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
}

package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * <p>
 * Address pojo class which has setter and getter methods for accessing address details. 
 * </p>
 * 
 * @author Madhan
 * 
 * @since 2016-09-01
 */
@Entity
@Table(name = "address")
public class Address {
	
    @Id 
    @Column(name = "address_id")
    private int addressId;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "pincode")
    private int pincode;
    
    @Column(name = "landmark")
    private String landmark;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    
	/**
	 * Constructor which has arguments is used to create address object.
	 * 
	 * @param addressId
	 * 		Contains unique id for address.
	 * @param street
	 * 		It contains street name.
	 * @param city
	 * 		It contains city name of an user.
	 * @param state
	 * 		Contains state name of an user.
	 * @param pincode
	 * 		Contains pincode of an user.
	 * @param landmark
	 * 		It contains landmark name of an user.
	 */
    public Address(int addressId, String street, String city, String state, int pincode, String landmark) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.landmark = landmark;
	}
    
    public Address() { }    
    
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}
    
	public User getUser() {
		return user;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
    
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", landmark=" + landmark + "]";
	}
}

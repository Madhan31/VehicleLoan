package com.i2i.vehicleloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.i2i.vehicleloan.model.Vehicle;

/**
 * Vehicle model pojo class which has setter and getter methods for accessing vehicle model details.
 * 
 * @author admin-pc
 *
 */
@Entity
@Table(name = "vehicle_model")
public class VehicleModel {
    
    @Id
    @Column(name = "vehicle_model_id", unique = true)
    private int vehicleModelId;
    
    @Column(name = "vehicle_model_name")
    private String vehicleModelName;
    
    @Column(name = "price_in_rupees")
    private int price;
    
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    /**
     * Constructor without argument is used to create a vehicle model object.
     */
    public VehicleModel() {
    }
    
    /**
     * Constructor with argument is used to create a vehicle model object.
     * 
     * @param vehicleModelId
     *     Contains unique id for an vehicle model.
     * @param vehicleModelName
     *     Contains name of vehicle barnd name.
     * @param price
     *     Contains cost price of a vehicle model.  
     * @param vehicle
     *     Contains object of class vehicle.
     */
	public VehicleModel(int vehicleModelId, String vehicleModelName, int price, Vehicle vehicle) {
		super();
		this.vehicleModelId = vehicleModelId;
		this.vehicleModelName = vehicleModelName;
		this.price = price;
		this.vehicle = vehicle;
	}  
   
    public int getVehicleModelId() {
        return vehicleModelId;
    }
   
    public String getVehicleModelName() {
        return vehicleModelName;
    }
    
    public Vehicle vehicle() {
        return vehicle;
    }
    
    public void setVehicleModelId(int vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }
   
    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }
    
    public void setLoanType(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
   

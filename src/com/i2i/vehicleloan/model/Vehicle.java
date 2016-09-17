package com.i2i.vehicleloan.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;	

import com.i2i.vehicleloan.model.VehicleModel;

/**
 * Vehicle pojo class which has setter and getter methods for accessing vehicle details.
 * 
 * @author vicky
 *
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {
    
    @Id
    @Column(name = "vehicle_id" , unique = true)
    private int vehicleId;
    
    @Column(name = "vehicle_name")
    private String vehicleName;
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_model_id")
    private Set<VehicleModel> vehicleModels = new HashSet<VehicleModel>();
    
    /**
     * Constructor without argument is used to create a vehicle object.
     */
    public Vehicle() {
    }
    
    /**
     * Constructor with argument is used to create a vehicle object.
     * 
     * @param vehicleId
     *     Contains unique id for an vehicle.
     * @param vehicleName
     *     Contains vehicle company name.
     */
    public Vehicle(int vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
    }
   
    public int getVehicleId() {
        return vehicleId;
    }
    
    public String getVehicleName() {
        return vehicleName;
    }
    
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
   
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

	public Set<VehicleModel> getVehicleModels() {
		return vehicleModels;
	}

	public void setVehicleModels(Set<VehicleModel> vehicleModels) {
		this.vehicleModels = vehicleModels;
	}
}
   

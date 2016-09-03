package model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;	

import model.VehicleModel;

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
    
    public Vehicle() {
    }
   
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
   

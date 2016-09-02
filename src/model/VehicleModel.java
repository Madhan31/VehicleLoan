package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import model.Vehicle;

@Entity
@Table(name = "brand")
public class VehicleModel {
    
    @Id
    @Column(name = "brand_id", unique = true)
    private int vehicleModelId;
    
    @Column(name = "brand_name")
    private String vehicleModelName;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    public VehicleModel() {
    }
   
    public VehicleModel(int vehicleModelId, String vehicleModelName) {
        this.vehicleModelId = vehicleModelId;
        this.vehicleModelName = vehicleModelName;
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
}
   

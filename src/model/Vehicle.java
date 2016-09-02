package model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.Brand;

@Entity
@Table(name = "vehicle")
public class Vechicle {
    
    @Id
    @Column(name = "vehicle_id" , unique = "true")
    private int vehicleId;
    
    @Column(name = "vehicle_name")
    private String vehicleName;
    
    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Set<Brand> brands = new HashSet<Brand>();
    
    public Vechicle() {
    }
   
    public Vechicle(int vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
    }
   
    public int getVehicleId() {
        return vehicleId;
    }
    
    public String getVehicleName() {
        return vehicleName;
    }
    
    public Set getBrands() {
        return brands;
    }
    
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
   
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    
    public void setBrands(Set brands) {
        this.brands = brands;
    }
}
   

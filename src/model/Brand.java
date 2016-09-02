package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import model.Vehicle;

@Entity
@Table(name = "brand")
public class Brand {
    
    @Id
    @Column(name = "brand_id", unique = true)
    private int brandId;
    
    @Column(name = "brand_name")
    private String brandName;
    
    @OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    public Brand() {
    }
   
    public Brand(int brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }
   
    public int getBrandId() {
        return brandId;
    }
   
    public String getBrandName() {
        return brandName;
    }
    
    public Vehicle vehicle() {
        return vehicle;
    }
    
    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
   
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public void setLoanType(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
   

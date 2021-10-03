package nl.rentmycar.Car;

import javax.persistence.*;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id",nullable = false)
    private Long id;
    private String brand;
    private String image;
    private String brandModel;
    private Integer kmDriven;
    private LocalDateTime endDateTime;
    private Integer carRange;
    private Double TCO;

    public Car(String brand,
               String image,
               String brandModel,
               Integer kmDriven,
               LocalDateTime endDateTime,
               Integer range,
               Double TCO)
    {
        this.brand = brand;
        this.image = image;
        this.brandModel = brandModel;
        this.kmDriven = kmDriven;
        this.endDateTime = endDateTime;
        this.carRange = range;
        this.TCO = TCO;
    }

    public Car(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    public Integer getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(Integer kmDriven) {
        this.kmDriven = kmDriven;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getcarRange() {
        return carRange;
    }

    public void setRange(Integer carRange) {
        this.carRange = carRange;
    }

    public Double getTCO() {
        return TCO;
    }

    public void setTCO(Double TCO) {
        this.TCO = TCO;
    }
}


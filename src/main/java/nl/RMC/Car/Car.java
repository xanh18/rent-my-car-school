package nl.RMC.Car;

import java.awt.*;
import java.util.Date;

public class Car {

    private Long id;
    private String brand;
    private Image image;
    private String brandModel;
    private Integer kmDriven;
    private Date endDateTime;
    private Integer range;
    private Double TCO;

    public Car(Long id,
               String brand,
               Image image,
               String brandModel,
               Integer kmDriven,
               Date endDateTime,
               Integer range,
               Double TCO) {
        this.id = id;
        this.brand = brand;
        this.image = image;
        this.brandModel = brandModel;
        this.kmDriven = kmDriven;
        this.endDateTime = endDateTime;
        this.range = range;
        this.TCO = TCO;
    }

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Double getTCO() {
        return TCO;
    }

    public void setTCO(Double TCO) {
        this.TCO = TCO;
    }
}

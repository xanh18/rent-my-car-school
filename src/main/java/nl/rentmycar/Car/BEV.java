package nl.rentmycar.Car;

import nl.rentmycar.Car.Car;

import java.time.LocalDateTime;

public class BEV extends Car {

    private Double batteryPercentage;


    public BEV(
               String brand,
               String image,
               String brandModel,
               Integer kmDriven,
               LocalDateTime endDateTime,
               Integer range,
               Double TCO,
               Double batteryPercentage) {
        super(brand, image, brandModel, kmDriven, endDateTime, range, TCO);
        this.batteryPercentage = batteryPercentage;
    }
}

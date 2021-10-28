package nl.rentmycar.Car;

import nl.rentmycar.Car.Car;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BEV extends Car { //subclass of Car

    private Double batteryPercentage;


    public BEV(
               String brand,
               String image,
               String brandModel,
               Integer kmDriven,
               LocalDateTime startDateTime,
               LocalDateTime endDateTime,
               Integer range,
               Double TCO,
               Double batteryPercentage) {
        super(brand, image, brandModel, kmDriven, startDateTime, endDateTime, range, TCO);
        this.batteryPercentage = batteryPercentage;
    }
}

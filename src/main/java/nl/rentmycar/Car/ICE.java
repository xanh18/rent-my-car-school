package nl.rentmycar.Car;

import nl.rentmycar.Car.Car;

import java.time.LocalDateTime;

public class ICE extends Car {

    private Integer tank;

    public ICE(
               String brand,
               String image,
               String brandModel,
               Integer kmDriven,
               LocalDateTime endDateTime,
               Integer range,
               Double TCO) {
        super(brand, image, brandModel, kmDriven, endDateTime, range, TCO);
    }
}

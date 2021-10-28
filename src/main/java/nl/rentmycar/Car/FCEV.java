package nl.rentmycar.Car;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.awt.*;
import nl.rentmycar.Car.Car;

import java.time.LocalDateTime;

public class FCEV extends Car{ //subclass of Car

    private Double batteryPercentage;
    private Double hydrogen;

    public FCEV(
            String brand,
            String image,
            String brandModel,
            Integer kmDriven,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            Integer range,
            Double TCO) {
        super( brand, image, brandModel, kmDriven, startDateTime, endDateTime, range, TCO);
    }
}

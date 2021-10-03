package nl.rentmycar.Rent.My.Car;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.awt.*;
import java.time.LocalDateTime;

public class FCEV extends Car{


    private Double batteryPercentage;
    private Double hydrogen;

    public FCEV(
            String brand,
            String image,
            String brandModel,
            Integer kmDriven,
            LocalDateTime endDateTime,
            Integer range,
            Double TCO) {
        super( brand, image, brandModel, kmDriven, endDateTime, range, TCO);
    }
}

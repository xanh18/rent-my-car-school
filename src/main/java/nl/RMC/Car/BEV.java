package nl.RMC.Car;

import java.awt.*;
import java.util.Date;

public class BEV extends Car{

    private Double batteryPercentage;


    public BEV(Long id,
               String brand,
               Image image,
               String brandModel,
               Integer kmDriven,
               Date endDateTime,
               Integer range,
               Double TCO,
               Double batteryPercentage) {
        super(id, brand, image, brandModel, kmDriven, endDateTime, range, TCO);
        this.batteryPercentage = batteryPercentage;
    }
}

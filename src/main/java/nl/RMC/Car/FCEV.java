package nl.RMC.Car;

import java.awt.*;
import java.util.Date;

public class FCEV extends Car{

    private Double batteryPercentage;
    private Double hydrogen;

    public FCEV(Long id,
                String brand,
                Image image,
                String brandModel,
                Integer kmDriven,
                Date endDateTime,
                Integer range,
                Double TCO) {
        super(id, brand, image, brandModel, kmDriven, endDateTime, range, TCO);
    }
}

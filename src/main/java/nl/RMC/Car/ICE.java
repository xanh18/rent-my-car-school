package nl.RMC.Car;

import java.awt.*;
import java.util.Date;

public class ICE extends Car{

    private Integer tank;

    public ICE(Long id,
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

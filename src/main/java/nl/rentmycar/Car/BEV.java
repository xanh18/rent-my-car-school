package nl.rentmycar.Car;

import java.time.LocalDateTime;

public class BEV extends Car { //subclass of Car

    private Double batteryPercentage;

    public Double getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(Double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

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

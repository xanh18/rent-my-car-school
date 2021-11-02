package nl.rentmycar.Car;

import java.time.LocalDateTime;

public class FCEV extends Car{ //subclass of Car

    private Double batteryPercentage;
    private Double hydrogen;

    public Double getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(Double batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }

    public Double getHydrogen() {
        return hydrogen;
    }

    public void setHydrogen(Double hydrogen) {
        this.hydrogen = hydrogen;
    }

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

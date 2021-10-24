package nl.rentmycar.Trip;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double xAxis;
    private double yAxis;
    private double zAxis;

    @JsonBackReference(value="trip-acceleration")
    @OneToOne(mappedBy = "acceleration")
    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getxAxis() {
        return xAxis;
    }

    public void setxAxis(double xAxis) {
        this.xAxis = xAxis;
    }

    public double getyAxis() {
        return yAxis;
    }

    public void setyAxis(double yAxis) {
        this.yAxis = yAxis;
    }

    public double getzAxis() {
        return zAxis;
    }

    public void setzAxis(double zAxis) {
        this.zAxis = zAxis;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }



    public boolean equals(Acceleration acceleration){
        var currentSpeed = (acceleration.getxAxis() * acceleration.getxAxis()) + (acceleration.getyAxis() * acceleration.getyAxis());
        var previousSpeed = (this.getxAxis() * this.getxAxis()) + (this.getyAxis() * this.getyAxis());
        var difference = currentSpeed - previousSpeed;
        if(difference < 0){
            difference = (difference * -1.00);
        }
        if(difference > 25){
            return false;
        }
        return true;
    }

    public Acceleration(){}

    public Acceleration(double xAxis, double yAxis, double zAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.zAxis = zAxis;
    }
}
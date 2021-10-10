package nl.rentmycar.Trip;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Acceleration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private AccelType type;
    private double speed;
    private double time;

    @JsonBackReference(value="trip-acceleration")
    @ManyToOne
    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccelType getType() {
        return type;
    }

    public void setType(AccelType type) {
        this.type = type;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public Acceleration(AccelType type, double speed, double time) {
        this.type = type;
        this.speed = speed;
        this.time = time;
    }

    public Acceleration(){}

    @Override
    public String toString() {
        return "Acceleration{" +
                "id=" + id +
                ", type=" + type +
                ", speed=" + speed +
                ", time=" + time +
                '}';
    }
}
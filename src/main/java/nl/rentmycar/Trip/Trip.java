package nl.rentmycar.Trip;

import nl.rentmycar.Car.Car;
import nl.rentmycar.Trip.Acceleration;
import nl.rentmycar.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private double distance;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private double longitude;
    private double latitude;
    private double TCO;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(targetEntity = Acceleration.class, cascade = CascadeType.ALL, mappedBy="trip")
    public List<Acceleration> accelerations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getTCO() {
        return TCO;
    }

    public void setTCO(double TCO) {
        this.TCO = TCO;
    }

    public List<Acceleration> accelerations() {
        return accelerations;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }

    public void addAcceleration(Acceleration acceleration) {
        acceleration.setTrip(this);
        this.accelerations.add(acceleration);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", distance=" + distance +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", TCO=" + TCO +
                '}';
    }

    public Trip(double distance, LocalDateTime startDateTime, LocalDateTime endDateTime, double longitude, double latitude, double TCO, User user, Car car) {
        this.distance = distance;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.TCO = TCO;
        this.accelerations = new ArrayList<>();
        this.user = user;
        this.car = car;
    }

    public Trip(){
        this.accelerations = new ArrayList<>();
    }
}

package nl.rentmycar.Trip;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String location;
    @ElementCollection
    private List<String> locations;

    @JsonBackReference(value="car-trip")
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @JsonBackReference(value="user-trip")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonManagedReference(value="trip-acceleration")
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Acceleration.class, cascade = CascadeType.ALL, mappedBy="trip")
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
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

    public void addToLocations(String location){
        this.locations.add(location);
        this.setLocation(location);
    }

    public boolean equals(Trip trip){
        if(this.location.equals(trip.getLocation())){
            return true;
        }
        return false;
    }

    public void addAcceleration(Acceleration acceleration) {
        acceleration.setTrip(this);
        this.accelerations.add(acceleration);
    }

    public Trip(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.accelerations = new ArrayList<>();
        this.locations = new ArrayList<>();
    }

    public Trip(){
        this.accelerations = new ArrayList<>();
        this.locations = new ArrayList<>();
    }
}

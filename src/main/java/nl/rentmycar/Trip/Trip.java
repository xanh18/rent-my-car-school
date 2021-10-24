package nl.rentmycar.Trip;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import nl.rentmycar.Car.Car;
import nl.rentmycar.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @JsonBackReference(value="car-trip") //Ensures no recursions happen when retrieving a Car.
    @ManyToOne(fetch = FetchType.LAZY)
    private Car car;

    @JsonBackReference(value="user-trip") //Ensures no recursions happen when retrieving a User.
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonManagedReference(value="trip-acceleration") //Ensures no recursions happen when retrieving a trip.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    public Acceleration acceleration;

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

    public Acceleration acceleration() {
        return acceleration;
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

    public Acceleration getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

    public boolean equals(Trip trip){
        if(this.location.equals(trip.getLocation())){ //Checks if car has moved by comparing new location to old location.
            return true;
        }
        return false;
    }

    public Trip(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.acceleration = new Acceleration(0,0,0); //Ensures there is always an acceleration, even if the Trip is new. Car is assumed to not be moving when the trip starts. Application is not compatible with action movie heroes that jump behind the wheel of an already moving car.
    }

    public Trip(){
        this.acceleration = new Acceleration(0,0,0); //Ensures there is always an acceleration, even if the Trip is new. Car is assumed to not be moving when the trip starts.
    }
}

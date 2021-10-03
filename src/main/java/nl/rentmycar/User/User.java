package nl.rentmycar.User;

import nl.rentmycar.Car.Car;
import nl.rentmycar.Trip.Acceleration;
import nl.rentmycar.Trip.Trip;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double longitude;
    private double latitude;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Trip.class, cascade = CascadeType.ALL, mappedBy="user")
    public List<Trip> trips;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Car.class, cascade = CascadeType.ALL, mappedBy="user")
    public List<Car> cars;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void addTrip(Trip trip) {
        trip.setUser(this);
        this.trips.add(trip);
    }

    public void addCar(Car car) {
        car.setUser(this);
        this.cars.add(car);
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public User(String email, String firstName, String lastName, String address, String phone, double longitude, double latitude) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
        this.cars = new ArrayList<>();
        this.trips = new ArrayList<>();
    }

    public User(){
        this.cars = new ArrayList<>();
        this.trips = new ArrayList<>();
    }


}

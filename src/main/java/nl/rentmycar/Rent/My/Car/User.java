package nl.rentmycar.Rent.My.Car;

import javax.persistence.*;

@Entity
@Table (name = "User")
public class User {


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL )
    @JoinColumn(name="car_id",nullable= false)
    private Car car;

    @OneToMany(mappedBy = "trip" , cascade = CascadeType.ALL )
    @JoinColumn(name="trip_id",nullable= false)
    private Trip trip;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// autoincrement
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private double longitude;
    private double latitude;

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


    public User(String email, String firstName, String lastName, String address, String phone, double longitude, double latitude) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public User(){

    }


}

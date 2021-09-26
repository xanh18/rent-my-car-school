package nl.rentmycar.Rent.My.Car;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

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
    private double range;
    private double TCO;

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

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getTCO() {
        return TCO;
    }

    public void setTCO(double TCO) {
        this.TCO = TCO;
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
                ", range=" + range +
                ", TCO=" + TCO +
                '}';
    }

    public Trip(double distance, LocalDateTime startDateTime, LocalDateTime endDateTime, double longitude, double latitude, double range, double TCO) {
        this.distance = distance;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.longitude = longitude;
        this.latitude = latitude;
        this.range = range;
        this.TCO = TCO;
    }

    public Trip(){

    }
}

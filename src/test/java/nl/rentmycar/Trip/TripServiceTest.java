package nl.rentmycar.Trip;

import nl.rentmycar.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TripServiceTest {

    TripService tripService;
    Trip fakeTrip;
    Acceleration fakeAccel;

    @BeforeEach
    void setUp() {
        fakeTrip = new Trip();
        fakeAccel = new Acceleration();
        fakeTrip.setId(1L);
        fakeTrip.setDistance(0);
        fakeTrip.setLocation("20.00,40.00");
        fakeTrip.setUser(new User());
        fakeTrip.setStartDateTime(LocalDateTime.now());
        fakeTrip.setEndDateTime(LocalDateTime.now());
        fakeAccel.setxAxis(5);
        fakeAccel.setyAxis(5);
        fakeAccel.setId(1L);
        fakeAccel.setTrip(fakeTrip);
        fakeTrip.setAcceleration(fakeAccel);


        TripRepository repository = Mockito.mock(TripRepository.class);
        Mockito.when(repository.findById(1L)).thenReturn(Optional.ofNullable(fakeTrip));
        tripService = new TripService(repository);
    }

    @Test
    void findById() {
        Trip trip = tripService.findById(1L).get();
        assertTrue(trip.getId() == 1L);
    }

    @Test
    void saveAcceleration() {
        Trip trip = new Trip();
        Acceleration acceleration = new Acceleration();
        trip.setId(1L);
        acceleration.setTrip(trip);
        acceleration.setxAxis(6);
        acceleration.setyAxis(6);
        trip.setAcceleration(acceleration);

        assertTrue(tripService.saveAcceleration(trip));
    }

    @Test
    void saveAcceleration_TooFast() {
        Trip trip = new Trip();
        Acceleration acceleration = new Acceleration();
        trip.setId(1L);
        acceleration.setTrip(trip);
        acceleration.setxAxis(10);
        acceleration.setyAxis(5);
        trip.setAcceleration(acceleration);

        assertFalse(tripService.saveAcceleration(trip));
    }
}
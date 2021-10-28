package nl.rentmycar.Trip;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {

    Trip trip;

    @BeforeEach
    void setUp() {
        trip = new Trip();
        trip.setLocation("40.00,40.00");
    }

    @Test
    void testEquals() {
        Trip newLocation = new Trip();
        newLocation.setLocation("40.00,40.00");
        assertTrue(trip.equals(newLocation));
    }

    @Test
    void testEqualsFalse() {
        Trip newLocation = new Trip();
        newLocation.setLocation("20.00,40.00");
        assertFalse(trip.equals(newLocation));
    }
}
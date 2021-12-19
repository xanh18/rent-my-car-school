package nl.rentmycar;


import nl.rentmycar.Car.Car;
import nl.rentmycar.Trip.Trip;
import nl.rentmycar.User.User;
import nl.rentmycar.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;


@SpringBootApplication
public class RentMyCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentMyCarApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository repo) {
        return (args -> insertTestData(repo));
    }

    private void insertTestData(UserRepository repo) {
        User user = new User("mail@mail.mail", "Rogal", "Dorn", "Address 1", "123456", 6, 7);
        Car car = new Car("volkswagen","welcome","gold",10, LocalDateTime.now(),LocalDateTime.now(),5344,12.12);
        Car car2 = new Car("volkswagen","welcome","gold",10,LocalDateTime.now(),LocalDateTime.now(),5344,12.12);
        Trip trip = new Trip(LocalDateTime.now(), LocalDateTime.now());
        Trip trip2 = new Trip(LocalDateTime.now(), LocalDateTime.now());
        user.addCar(car);
        user.addCar(car2);
        user.addTrip(trip);
        user.addTrip(trip2);
        car2.addTrip(trip2);
        car.addTrip(trip);
        repo.save(user);
    }
}

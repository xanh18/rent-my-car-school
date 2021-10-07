package nl.rentmycar;


import nl.rentmycar.Car.Car;
import nl.rentmycar.Car.CarRepository;
import nl.rentmycar.Trip.Trip;
import nl.rentmycar.Trip.AccelType;
import nl.rentmycar.Trip.Acceleration;
import nl.rentmycar.Trip.TripRepository;
import nl.rentmycar.User.User;
import nl.rentmycar.User.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;


@SpringBootApplication
public class RentMyCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentMyCarApplication.class, args);
	}

	@Bean
	public CommandLineRunner run (UserRepository repo){
		return (args -> {
//			insertUser(repo);
//			for (User user : repo.findUserByLastNameContaining("e")){
//				System.out.println(user);
//			}
			insertUser(repo);

		});
	}

	private void testAccels(TripRepository repo){
		Trip trip = new Trip(4, LocalDateTime.now(), LocalDateTime.now(), 3, 5, 1);
		trip.addAcceleration(new Acceleration(AccelType.Acceleration, 1, 2));
		repo.save(trip);
	}

	private void insertUser(UserRepository repo){
		User user = new User("mail@mail.mail", "Rogal", "Dorn", "Address 1", "123456", 6, 7,"test","test", true);
		Car car = new Car("volkswagen","welkom","gold",10, LocalDateTime.now(),10000,53.44);
		Trip trip = new Trip(4.00, LocalDateTime.now(), LocalDateTime.now(), 4.00, 4.00, 4.00);
		trip.addAcceleration(new Acceleration(AccelType.Acceleration, 1, 2));
		user.addCar(car);
		user.addTrip(trip);
		car.addTrip(trip);
		repo.save(user);
	}

	private Car insertCar(CarRepository repo){
		Car car1 = new Car("volkswagen","welkom","gold",10, LocalDateTime.now(),10000,53.44);
		Car car2 = new Car("volkswagen","Avans","gold",10, LocalDateTime.now(),10000,53.44);

		User user1 = new User("mail@mail.mail", "Rogal", "Dorn", "Address 1", "123456", 6, 7,"test","test", true);
		User user2 = new User("mail@mail.mail", "Roboute", "Guilliman", "Address 2", "123456", 6, 7,"pietje@mail.nl", "wachtwoord", true);
		User user3 = new User("mail@mail.mail", "Magnus", "the Red", "Address 3", "123456", 6, 7,"jantje@mail.nl", "Test1234", true);
		User user4 = new User("mail@mail.mail", "Konrad", "Curze", "Address 1", "123456", 6, 7,"keesie@mail.nl", "Test1234", true);
		User user5 = new User("mail@mail.mail", "Vulkan", "", "Address 2", "123456", 6, 7,"xanh@mail.nl", "Test1234", true);
		User user6 = new User("mail@mail.mail", "Horus", "Lupercal", "Address 3", "123456", 6, 7,"pieter@mail.nl", "Test1234", true);
		return repo.findById(1L).get();
	}

	private void insertTrip(TripRepository repo, User user, Car car){
		Trip trip = new Trip(4.00, LocalDateTime.now(), LocalDateTime.now(), 4.00, 4.00, 4.00);
	}

}

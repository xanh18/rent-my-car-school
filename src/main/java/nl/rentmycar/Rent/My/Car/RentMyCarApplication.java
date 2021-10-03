package nl.rentmycar.Rent.My.Car;


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
	public CommandLineRunner run (UserRepository userRepo, CarRepository carRepo, TripRepository tripRepo){


		return (args -> {
//			insertUser(repo);
//			for (User user : repo.findUserByLastNameContaining("e")){
//				System.out.println(user);
//			}
			User user = insertUser(userRepo);
			Car car = insertCar(carRepo);
			insertTrip(tripRepo, user, car);

		});
	}

	private User insertUser(UserRepository repo){
		repo.save(new User("mail@mail.mail", "Rogal", "Dorn", "Address 1", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Roboute", "Guilliman", "Address 2", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Magnus", "the Red", "Address 3", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Konrad", "Curze", "Address 1", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Vulkan", "", "Address 2", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Horus", "Lupercal", "Address 3", "123456", 6, 7));
		return repo.findById(1L).get();
	}

	private Car insertCar(CarRepository repo){
		repo.save(new Car("volkswagen","welkom","gold",10, LocalDateTime.now(),10000,53.44));
		repo.save(new Car("volkswagen","Avans","gold",10, LocalDateTime.now(),10000,53.44));
		return repo.findById(1L).get();
	}

	private void insertTrip(TripRepository repo, User user, Car car){
		Trip trip = new Trip(4.00, LocalDateTime.now(), LocalDateTime.now(), 4.00, 4.00, 4.00, user, car);
	}

}

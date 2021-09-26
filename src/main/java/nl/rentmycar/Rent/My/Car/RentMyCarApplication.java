package nl.rentmycar.Rent.My.Car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class RentMyCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentMyCarApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(UserRepository repo ){
		return (args -> {
			insertUser(repo);
			System.out.println(repo.findAll());
		});
	}

	private void insertUser(UserRepository repo){
		repo.save(new User("mail@mail.mail", "Firstname1", "Lastname1", "Address 1", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Firstname2", "Lastname2", "Address 2", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Firstname3", "Lastname3", "Address 3", "123456", 6, 7));
	}
}

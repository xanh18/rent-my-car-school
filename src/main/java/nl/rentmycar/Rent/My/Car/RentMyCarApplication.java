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
			//insertUser(repo);
			for (User user : repo.findUserByLastNameContaining("e")){
				System.out.println(user);
			}
		});
	}

	private void insertUser(UserRepository repo){
		repo.save(new User("mail@mail.mail", "Rogal", "Dorn", "Address 1", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Roboute", "Guilliman", "Address 2", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Magnus", "the Red", "Address 3", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Konrad", "Curze", "Address 1", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Vulkan", "", "Address 2", "123456", 6, 7));
		repo.save(new User("mail@mail.mail", "Horus", "Lupercal", "Address 3", "123456", 6, 7));
	}
}

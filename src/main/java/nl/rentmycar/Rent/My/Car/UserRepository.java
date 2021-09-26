package nl.rentmycar.Rent.My.Car;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByLastNameContaining(String str);

}

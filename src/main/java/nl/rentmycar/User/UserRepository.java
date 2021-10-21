package nl.rentmycar.User;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByLastNameContaining(String str);
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}

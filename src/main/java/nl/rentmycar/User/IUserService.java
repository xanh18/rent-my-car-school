package nl.rentmycar.User;

import java.util.List;
import java.util.Optional;


// the interface specifies what behavior classes could implement
public interface IUserService {

    List<User> findAll();

    Status deleteAll();

    Status registerUser(User user);

    Status loginUser(User user);

    Status logoutUser(User user);

    int findSocialCredit (String username);

    Optional<User> findById(long id);
}

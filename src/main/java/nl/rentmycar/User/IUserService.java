package nl.rentmycar.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    Status deleteAll();

    Status registerUser(User user);

    Status loginUser(User user);

    Status logUserOut(User user);
}

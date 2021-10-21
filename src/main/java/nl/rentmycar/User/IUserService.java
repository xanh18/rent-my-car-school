package nl.rentmycar.User;

import java.util.List;

public interface IUserService {
    List<User> findALl();
    Status deleteAll();

    Status registerUser(User user);

    Status loginUser(User user);

    Status logUserOut(User user);
}

package nl.rentmycar.User;

import java.util.List;


// the interface specifies what behavior classes could implement
public interface IUserService {

    List<User> findAll();

    Status deleteAll();

    Status registerUser(User user);

    Status loginUser(User user);

    Status logUserOut(User user);

    int findSocialCredit (String username);
}

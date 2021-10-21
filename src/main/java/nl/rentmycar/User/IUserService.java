package nl.rentmycar.User;

import java.util.List;

public interface IUserService {
    List<User> users = (List<User>) userRepository.findAll();
}

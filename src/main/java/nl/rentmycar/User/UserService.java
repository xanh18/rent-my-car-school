package nl.rentmycar.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findALl() {
        return (List<User>) repo.findAll();
    }

    @Override
    public Status deleteAll() {
        repo.deleteAll();
        return Status.SUCCESS;
    }

    @Override
    public Status registerUser(User newUser) {
        List<User> users = (List<User>) repo.findAll();
        System.out.println("New user: " + newUser.toString());
        for (User user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        repo.save(newUser);
        return Status.SUCCESS;
    }

    @Override
    public Status loginUser(User user) {
        List<User> users = (List<User>) repo.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                repo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @Override
    public Status logUserOut(User user) {
        List<User> users = (List<User>) repo.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
                repo.save(user);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
}

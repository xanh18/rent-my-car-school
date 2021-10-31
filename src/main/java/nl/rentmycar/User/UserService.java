package nl.rentmycar.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findAll() {
        return (List<User>) repo.findAll();
    } //finds all users

    @Override // deletes all users
    public Status deleteAll() {
        repo.deleteAll();
        return Status.SUCCESS;
    }

    @Override // registers all users
    public Status registerUser(User user) {
        if(repo.findByUsername(user.getUsername()).isPresent()){
            return Status.USER_ALREADY_EXISTS;
        }
        repo.save(user);
        return Status.SUCCESS;
    }

    @Override //logins the user
    public Status loginUser(User attempt) {
        Optional<User> optional = repo.findByUsernameAndPassword(attempt.getUsername(), attempt.getPassword());
        if(optional.isPresent()){
            User user = optional.get();
            user.setLoggedIn(true);
            repo.save(user);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }

    @Override //logs the user out
    public Status logoutUser(User user) {
        Optional<User> optional = repo.findById(user.getId());
        if(optional.isPresent()){
            user = optional.get();
            user.setLoggedIn(false);
            repo.save(user);
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }

    @Override // finds the social credit of the user
    public int findSocialCredit (String username){
        Optional<User> optional = repo.findByUsername(username);
        if(optional.isPresent()){
            var user = optional.get();
            return user.getSocialCredit();
        }
        return -2147483648;
    }
}

package nl.rentmycar.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public User registerUser(User user) {
        Optional<User> optional = repo.findByUsername(user.getUsername());
        if(optional.isPresent()){
            return new User();
        }
        repo.save(user);
        return user;
    }

    @Override //logins the user
    public User loginUser(User attempt) {
        Optional<User> optional = repo.findByUsernameAndPassword(attempt.getUsername(), attempt.getPassword());
        if(optional.isPresent()){
            User user = optional.get();
            user.setLoggedIn(true);
            repo.save(user);
            return user;
        }
        User user = new User();
        return user;
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

    @Override
    public Optional<User> findById(long id) {
        System.out.print(repo.findById(id));
        return repo.findById(id);
    }

    @Override
    public int lowerSocialCredit(User user) {
        System.out.println("eh");
        Optional<User> optional = repo.findById(user.getId());
        if(optional.isPresent()) {
            user = optional.get();
            user.setSocialCredit(user.getSocialCredit() - 1);
            repo.save(user);
            System.out.println(user.getSocialCredit());
            return user.getSocialCredit();
        }
        return 0;
    }
}

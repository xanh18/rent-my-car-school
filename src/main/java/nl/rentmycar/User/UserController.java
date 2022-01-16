package nl.rentmycar.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/findall")
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    //@PostMapping(“/users/register”): This tells Spring that whenever our program receives a Post Request to /users/register
    //the registerUser function should be called, and then it passes the received data to the registerUser function.
    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public User loginUser(@Valid @RequestBody User user) {
        return userService.loginUser(user);
    }
    @PostMapping("/logout")
    public Status logoutUser(@Valid @RequestBody User user) {
        return userService.logoutUser(user);
    }

    //@DeleteMapping(“/users/all”):
    // This tells Spring to call the following function whenever a Delete Request has been issued to /users/all.
    @DeleteMapping("/all")
    public Status deleteAll() {
        return userService.deleteAll();
    }

    @GetMapping("/score/{username}")
    public int findSocialCredit(@PathVariable String username){
        return userService.findSocialCredit(username);
    }

    @PostMapping("/lower")
    public int lowerSocialCredit(@Valid @RequestBody User user) { return userService.lowerSocialCredit(user); }

}
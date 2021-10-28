package nl.rentmycar.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;


    //@PostMapping(“/users/register”): This tells Spring that whenever our program receives a Post Request to /users/register
    // that the registerUser function should be called and then it pasts the received data to the registerUser function.
    @PostMapping("/register")
    public Status registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public Status loginUser(@Valid @RequestBody User user) {
        return userService.loginUser(user);
    }
    @PostMapping("/logout")
    public Status logUserOut(@Valid @RequestBody User user) {
        return userService.logUserOut(user);
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

}
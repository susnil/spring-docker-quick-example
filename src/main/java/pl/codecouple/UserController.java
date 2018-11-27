package pl.codecouple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @RequestMapping("/")
    public @ResponseBody String home() {
        String message = "Hello accounts service! ";
        try {
            message = message + InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return message;
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public @ResponseBody
    User getUserByUsername(@RequestParam("username") String username) {
        return repository.findByUsername(username);
    }

}
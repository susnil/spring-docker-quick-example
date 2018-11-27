package pl.codecouple;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserRepository {
    private static final List<User> userList = Arrays.asList(
            new User("user0", "passowrd0", "email@poczta.pl"));

    public User findByUsername(String name) {
        for (User user : userList) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllMonster() {
        return userList;
    }
}
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            // Обработка ошибки "пользователь не найден"
        }

        // Обновление свойств пользователя
        existingUser.setName(user.getName());
        existingUser.setLogin(user.getLogin());
        existingUser.setPassword(user.getPassword());
        existingUser.setRoles(user.getRoles());

        return userService.saveUser(existingUser);
    }



    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}

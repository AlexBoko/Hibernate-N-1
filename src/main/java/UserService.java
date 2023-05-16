import com.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long userId);
    User getUserByLogin(String login);
    List<User> getUsersByRole(String roleName);
    void deleteUser(Long userId);
    User saveUser(User user);
}

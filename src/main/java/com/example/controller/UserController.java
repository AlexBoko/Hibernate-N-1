package com.example.controller;

import com.example.model.CreateUserRequest;
import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public User createUser(@RequestBody CreateUserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setLogin(request.getLogin());
        user.setPassword(request.getPassword());

        // Получение и установка ролей пользователя
        Set<Role> roles = new HashSet<>();
        for (Long roleId : request.getRoleIds()) {
            Role role = userService.getRoleById(roleId);
            if (role != null) {
                roles.add(role);
            }
        }
        user.setRoles((List<Role>) roles);

        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        User existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            // Обработка ошибки "пользователь не найден"
            throw new RuntimeException("Пользователь с ID " + userId + " не найден");
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

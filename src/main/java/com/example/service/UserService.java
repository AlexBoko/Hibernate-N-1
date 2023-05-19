package com.example.service;

import com.example.model.Role;
import com.example.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    // ... остальные методы интерфейса UserService ...

    List<User> getUsers();

    User getUserById(Long userId);

    User getUserByLogin(String login);

    List<User> getUsersByRole(String roleName);

    Role getRoleById(Long roleId);

    List<Role> getAllRoles();

    Role saveRole(Role role);

    void deleteRole(Long roleId);

    @Transactional
    void deleteUser(Long userId);

    @Transactional
    User saveUser(User user);

    List<User> getUsersByRoleName(String roleName);
}

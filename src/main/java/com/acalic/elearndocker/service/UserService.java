package com.acalic.elearndocker.service;

import com.acalic.elearndocker.domain.Role;
import com.acalic.elearndocker.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
    User getUserById(Long id);
}

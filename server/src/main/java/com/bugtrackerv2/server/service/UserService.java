package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.ERole;
import com.bugtrackerv2.server.domain.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void addRoleToUser(String username, ERole role);
    List<User> getAllUsers();
}

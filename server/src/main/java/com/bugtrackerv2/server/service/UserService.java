package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.domain.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();
}

package com.bugtrackerv2.server.service.impl;

import com.bugtrackerv2.server.domain.ERole;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.domain.User;
import com.bugtrackerv2.server.exception.EmailAlreadyExistsException;
import com.bugtrackerv2.server.exception.UsernameAlreadyExistsException;
import com.bugtrackerv2.server.repository.RoleRepository;
import com.bugtrackerv2.server.repository.UserRepository;
import com.bugtrackerv2.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username: " + user.getUsername() + " already exists!");
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email: " + user.getEmail() + " already exists!");
        }
        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Role not found!"));
        user.addRole(userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
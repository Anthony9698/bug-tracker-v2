package com.bugtrackerv2.server.service.impl;

import com.bugtrackerv2.server.domain.ERole;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.domain.User;
import com.bugtrackerv2.server.exception.EmailAlreadyExistsException;
import com.bugtrackerv2.server.exception.UsernameAlreadyExistsException;
import com.bugtrackerv2.server.repository.RoleRepository;
import com.bugtrackerv2.server.repository.UserRepository;
import com.bugtrackerv2.server.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    @Test
    void itShouldAddUser() {
        User user = new User("Joe", "Shmoe", "js123", "js@gmail.com", "password123");
        Role role = new Role(ERole.ROLE_USER);
        when(userRepository.existsByUsername(user.getUsername())).thenReturn(false);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);
        when(roleRepository.findByName(ERole.ROLE_USER)).thenReturn(Optional.of(role));
        underTest.addUser(user);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        assertThat(userArgumentCaptor.getValue()).isEqualTo(user);
    }

    @Test
    void itShouldThrowUsernameAlreadyExists() {
        User user = new User("Joe", "Smoe", "jdog123", "js@gmail.com", "password");
        when(userRepository.existsByUsername(user.getUsername())).thenReturn(true);
        assertThatThrownBy(() -> underTest.addUser(user))
                .isInstanceOf(UsernameAlreadyExistsException.class)
                .hasMessage("Username: " + user.getUsername() + " already exists!");
    }

    @Test
    void isShouldThrowEmailAlreadyExists() {
        User user = new User("Joe", "Smoe", "jdog123", "js@gmail.com", "password");
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);
        assertThatThrownBy(() -> underTest.addUser(user))
                .isInstanceOf(EmailAlreadyExistsException.class)
                .hasMessage("Email: " + user.getEmail() + " already exists!");
    }

    @Test
    void itShouldGetAllUsers() {
        underTest.getAllUsers();
        verify(userRepository).findAll();
    }

    @Test
    void itShouldAddRoleToUser() {
        Role role = new Role(ERole.ROLE_USER);
        User user = new User("Joe", "Smoe", "jdog123", "js@gmail.com", "password");
        when(roleRepository.findByName(role.getName())).thenReturn(Optional.of(role));
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));
        underTest.addRoleToUser(user.getUsername(), role.getName());
        verify(userRepository).save(user);
    }
}
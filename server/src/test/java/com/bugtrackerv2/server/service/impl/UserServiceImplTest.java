//package com.bugtrackerv2.server.service.impl;
//
//import com.bugtrackerv2.server.domain.User;
//import com.bugtrackerv2.server.domain.Role;
//import com.bugtrackerv2.server.repo.AppUserRepo;
//import com.bugtrackerv2.server.repo.RoleRepo;
//import com.bugtrackerv2.server.service.UserService;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceImplTest {
//    @Mock
//    private AppUserRepo appUserRepo;
//    @Mock
//    private RoleRepo roleRepo;
//    @Mock
//    private PasswordEncoder passwordEncoder;
//    private UserService underTest;
//
//    @BeforeEach
//    void setUp() {
//        underTest = new AppUserServiceImpl(appUserRepo, roleRepo, passwordEncoder);
//    }
//
//    @Test
//    void canAddAppUser() {
//        // given
//        User user = new User("John", "Doe", "j@gmail.com", "password");
//        // when
//        underTest.addAppUser(user);
//        // then
//        ArgumentCaptor<User> appUserArgumentCaptor = ArgumentCaptor.forClass(User.class);
//        verify(appUserRepo).save(appUserArgumentCaptor.capture());
//        assertThat(appUserArgumentCaptor.getValue()).isEqualTo(user);
//    }
//
//    @Test
//    void canAddRoleToAppUser() {
//        // given
//        String adminEmail = "a@gmail.com";
//        String role = "manager";
//        // when
//        User adminUser = new User("Anthony", "Viera", "a@gmail.com", "1234");
//        Role managerRole = new Role("manager");
//        when(appUserRepo.findByEmail("a@gmail.com")).thenReturn(adminUser);
//        when(roleRepo.findByName("manager")).thenReturn(managerRole);
//        underTest.addRoleToAppUser(adminEmail, role);
//        // then
//        ArgumentCaptor<String> emailArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        ArgumentCaptor<String> roleNameArgumentCaptor = ArgumentCaptor.forClass(String.class);
//        verify(appUserRepo).findByEmail(emailArgumentCaptor.capture());
//        verify(roleRepo).findByName(roleNameArgumentCaptor.capture());
//        assertThat(adminUser.getRoles().size()).isEqualTo(1);
//    }
//
//    @Test
//    @Disabled
//    void getAppUser() {
//    }
//
//    @Test
//    void canGetAllAppUsers() {
//        underTest.getAllAppUsers();
//        verify(appUserRepo).findAll();
//    }
//
//    @Test
//    @Disabled
//    void loadUserByUsername() {
//    }
//}
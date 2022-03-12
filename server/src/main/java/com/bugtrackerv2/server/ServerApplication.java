package com.bugtrackerv2.server;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    CommandLineRunner run(AppUserService appUserService) {
//        return args -> {
//            appUserService.saveRole(new Role(null, "ROLE_USER"));
//            appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
//            appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
//            appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
//            appUserService.saveAppUser(new AppUser(null, "anthony", "viera", "a@gmail.com", "1234", new HashSet<>()));
//            appUserService.saveAppUser(new AppUser(null, "will", "smith", "ws@gmail.com", "1234", new HashSet<>()));
//            appUserService.saveAppUser(new AppUser(null, "john", "trav", "jt@gmail.com", "1234", new HashSet<>()));
//            appUserService.saveAppUser(new AppUser(null, "mitch", "conner", "mc@gmail.com", "1234", new HashSet<>()));
//
//            appUserService.addRoleToUser("a@gmail.com", "ROLE_ADMIN");
//            appUserService.addRoleToUser("jt@gmail.com", "ROLE_USER");
//            appUserService.addRoleToUser("jt@gmail.com", "ROLE_SUPER_ADMIN");
//            appUserService.addRoleToUser("mc@gmail.com", "ROLE_MANAGER");
//        };
//    }
}

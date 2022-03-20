package com.bugtrackerv2.server.config;

import com.bugtrackerv2.server.domain.ERole;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.domain.User;
import com.bugtrackerv2.server.service.RoleService;
import com.bugtrackerv2.server.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootStrap {
    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
            roleService.addRole(new Role(ERole.ROLE_USER));
            roleService.addRole(new Role(ERole.ROLE_DEVELOPER));
            roleService.addRole(new Role(ERole.ROLE_MANAGER));
            roleService.addRole(new Role(ERole.ROLE_ADMIN));
        };
    }
}

package com.bugtrackerv2.server.config;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.service.AppUserService;
import com.bugtrackerv2.server.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBootStrap {
    @Bean
    CommandLineRunner run(AppUserService appUserService, RoleService roleService) {
        return args -> {
            roleService.addRole(new Role("admin"));
            appUserService.addAppUser(new AppUser("anthony", "viera", "a@gmail.com", "1234"));
            appUserService.addRoleToAppUser("a@gmail.com", "admin");
        };
    }
}

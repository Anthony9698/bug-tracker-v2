package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.repo.AppUserRepo;
import com.bugtrackerv2.server.repo.RoleRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl implements AppUserService, UserDetailsService {
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;

    @Override
    public AppUser saveAppUser(AppUser appUser) {
        log.info("Saving new user {} to the database", appUser.getEmail());
        return appUserRepo.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to user {}", roleName, email);
        AppUser appUser = appUserRepo.findByEmail(email);
        Role role = roleRepo.findByName(roleName);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser getAppUser(String email) {
        log.info("Fetching user {}", email);
        return appUserRepo.findByEmail(email);
    }

    @Override
    public List<AppUser> getAppUsers() {
        log.info("Fetching all users");
        return appUserRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(email);
        if (appUser == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(appUser.getEmail(), appUser.getPassword(), authorities);
    }
}

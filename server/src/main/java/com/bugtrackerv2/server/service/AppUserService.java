package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveAppUser(AppUser appUser);
    AppUser getAppUser(String email);
    List<AppUser> getAppUsers();
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
}
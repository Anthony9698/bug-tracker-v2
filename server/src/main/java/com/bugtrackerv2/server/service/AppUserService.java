package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;

import java.util.List;
import java.util.Set;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);

    AppUser getAppUser(String email);

    List<AppUser> getAppUsers();

    Set<Role> addRoleToAppUser(String email, String roleName);
}

package com.bugtrackerv2.server.service;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.mapstruct.dtos.user.AppUserAllDto;

import java.util.List;
import java.util.Set;

public interface AppUserService {
    AppUser addAppUser(AppUser appUser);

    AppUser getAppUser(String email);

    List<AppUserAllDto> getAllAppUsers();

    Set<Role> addRoleToAppUser(String email, String roleName);
}

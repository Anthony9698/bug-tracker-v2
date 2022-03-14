package com.bugtrackerv2.server.service.impl;

import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.repo.RoleRepo;
import com.bugtrackerv2.server.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Override
    public Role addRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }
}

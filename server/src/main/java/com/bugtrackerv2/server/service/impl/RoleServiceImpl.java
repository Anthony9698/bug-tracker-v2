package com.bugtrackerv2.server.service.impl;

import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.repository.RoleRepository;
import com.bugtrackerv2.server.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public void addRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        roleRepository.save(role);
    }
}

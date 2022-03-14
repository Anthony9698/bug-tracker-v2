package com.bugtrackerv2.server.repo;

import com.bugtrackerv2.server.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

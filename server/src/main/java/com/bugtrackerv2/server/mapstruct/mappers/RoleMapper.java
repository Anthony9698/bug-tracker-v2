package com.bugtrackerv2.server.mapstruct.mappers;

import com.bugtrackerv2.server.domain.Role;
import com.bugtrackerv2.server.mapstruct.dtos.role.RoleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDto roleToRoleDto(Role role);
}

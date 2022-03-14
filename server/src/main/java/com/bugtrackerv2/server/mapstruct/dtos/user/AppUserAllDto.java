package com.bugtrackerv2.server.mapstruct.dtos.user;

import com.bugtrackerv2.server.mapstruct.dtos.role.RoleDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AppUserAllDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("roles")
    private Set<RoleDto> roles;
}

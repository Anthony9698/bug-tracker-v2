package com.bugtrackerv2.server.mapstruct.dtos.roles;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}

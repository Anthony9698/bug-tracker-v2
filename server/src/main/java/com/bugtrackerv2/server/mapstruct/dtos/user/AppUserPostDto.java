package com.bugtrackerv2.server.mapstruct.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AppUserPostDto {
    @JsonProperty("id")
    private Long id;

    @NotBlank
    @Size(min = 2, max = 32, message = "First name must be between 2 and 32 characters long")
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 32, message = "Last name must be between 2 and 32 characters long")
    @JsonProperty("lastName")
    private String lastName;

    @Email
    @NotBlank
    @JsonProperty("email")
    private String email;

    @NotNull
    @JsonProperty("password")
    private String password;
}

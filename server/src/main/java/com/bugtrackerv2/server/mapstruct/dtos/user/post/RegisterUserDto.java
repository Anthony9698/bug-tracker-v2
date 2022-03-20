package com.bugtrackerv2.server.mapstruct.dtos.user.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterUserDto {
    @NotBlank
    @Size(min = 5, max = 10, message = "Username must be between 5 and 10 characters long")
    @JsonProperty("username")
    protected String username;
    @NotNull
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters long")
    @JsonProperty("password")
    protected String password;
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
}

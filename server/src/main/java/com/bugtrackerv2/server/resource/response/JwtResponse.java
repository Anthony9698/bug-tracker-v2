package com.bugtrackerv2.server.resource.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private List<String> roles;

    public JwtResponse(String token, Long id, String firstName, String lastName, String userName, String email,
                       List<String> roles) {
        this.token = token;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.roles = roles;
    }
}

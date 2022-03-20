//package com.bugtrackerv2.server.resource;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.bugtrackerv2.server.domain.Role;
//import com.bugtrackerv2.server.domain.User;
//import com.bugtrackerv2.server.mapstruct.dtos.user.UserAllDto;
//import com.bugtrackerv2.server.mapstruct.dtos.user.UserDto;
//import com.bugtrackerv2.server.mapstruct.dtos.user.post.UserPostDto;
//import com.bugtrackerv2.server.mapstruct.mappers.UserMapper;
//import com.bugtrackerv2.server.service.UserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.io.IOException;
//import java.net.URI;
//import java.util.*;
//import java.util.stream.Collectors;
//
//import static org.springframework.http.HttpHeaders.AUTHORIZATION;
//import static org.springframework.http.HttpStatus.FORBIDDEN;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
//@RestController
//@RequestMapping("/users")
//@RequiredArgsConstructor
//@Slf4j
//public class UserResource {
//    private final UserService userService;
//    private final UserMapper userMapper;
//
//    @GetMapping
//    public ResponseEntity<List<UserAllDto>> getAppUsers() {
//        List<UserAllDto> userAllDto = userMapper.appUserToAppUserAllDtos(userService.getAllAppUsers());
//        return ResponseEntity.ok().body(userAllDto);
//    }
//
//    @PostMapping
//    public ResponseEntity<UserDto> registerAppUser(@RequestBody @Valid UserPostDto userPostDto) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
//        User newUser = userMapper.appUserPostDtoToAppUser(userPostDto);
//        UserDto userDto = userMapper.appUserToAppUserDto(userService.addAppUser(newUser));
//        return ResponseEntity.created(uri).body(userDto);
//    }
//
//    @PostMapping("/{email}/roles")
//    public ResponseEntity<Set<Role>> addRoleToAppUser(@PathVariable("email") String email, @RequestBody Role role) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/" + email + "/roles").toUriString());
//        return ResponseEntity.created(uri).body(userService.addRoleToAppUser(email, role.getName()));
//    }
//
//    @GetMapping("/token/refresh")
//    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String authorizationHeader = request.getHeader(AUTHORIZATION);
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            try {
//                String refresh_token = authorizationHeader.substring("Bearer ".length());
//                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//                JWTVerifier verifier = JWT.require(algorithm).build();
//                DecodedJWT decodedJWT = verifier.verify(refresh_token);
//                String email = decodedJWT.getSubject();
//
//                User user = userService.getAppUser(email);
//                String access_token = JWT.create()
//                        .withSubject(user.getEmail())
//                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
//                        .withIssuer(request.getRequestURL().toString())
//                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
//                        .sign(algorithm);
//                Map<String, String> tokens = new HashMap<>();
//                tokens.put("access_token", access_token);
//                tokens.put("refresh_token", refresh_token);
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
//            } catch (Exception e) {
//                log.error("Error logging in: {}", e.getMessage());
//                response.setHeader("error", e.getMessage());
//                response.setStatus(FORBIDDEN.value());
//                Map<String, String> error = new HashMap<>();
//                error.put("error_message", e.getMessage());
//                response.setContentType(APPLICATION_JSON_VALUE);
//                new ObjectMapper().writeValue(response.getOutputStream(), error);
//            }
//        } else {
//            throw new RuntimeException("Refresh token is missing");
//        }
//    }
//}

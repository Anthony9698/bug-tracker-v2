package com.bugtrackerv2.server.controllers;

import com.bugtrackerv2.server.mapstruct.dtos.user.post.LoginUserDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.post.RegisterUserDto;
import com.bugtrackerv2.server.mapstruct.mappers.UserMapper;
import com.bugtrackerv2.server.resource.response.JwtResponse;
import com.bugtrackerv2.server.resource.response.MessageResponse;
import com.bugtrackerv2.server.security.jwt.JwtUtils;
import com.bugtrackerv2.server.service.UserService;
import com.bugtrackerv2.server.service.impl.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserDto registerUserPostDto) {
        userService.addUser(userMapper.registerUserDtoToUser(registerUserPostDto));
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginUserDto loginUserDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(), loginUserDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getFirstName(),
                userDetails.getLastName(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }
}

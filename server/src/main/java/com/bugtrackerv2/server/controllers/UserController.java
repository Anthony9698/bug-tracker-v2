package com.bugtrackerv2.server.controllers;

import com.bugtrackerv2.server.mapstruct.dtos.user.UserAllDto;
import com.bugtrackerv2.server.mapstruct.mappers.UserMapper;
import com.bugtrackerv2.server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserAllDto>> getAllUsers() {
        return ResponseEntity.ok(userMapper.allUsersToAllDtoUsers(userService.getAllUsers()));
    }
}

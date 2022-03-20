package com.bugtrackerv2.server.mapstruct.mappers;

import com.bugtrackerv2.server.domain.User;
import com.bugtrackerv2.server.mapstruct.dtos.user.UserAllDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.UserDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.post.LoginUserDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.post.RegisterUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    List<UserAllDto> allUsersToAllDtoUsers(List<User> users);

    UserDto userToUserDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "projects", ignore = true)
    User registerUserDtoToUser(RegisterUserDto registerUserDto);
}

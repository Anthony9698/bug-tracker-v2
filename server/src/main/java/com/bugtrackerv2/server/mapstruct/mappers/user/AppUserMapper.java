package com.bugtrackerv2.server.mapstruct.mappers.user;

import com.bugtrackerv2.server.domain.AppUser;
import com.bugtrackerv2.server.mapstruct.dtos.user.AppUserAllDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.AppUserGetDto;
import com.bugtrackerv2.server.mapstruct.dtos.user.AppUserPostDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppUserMapper {
    List<AppUserAllDto> appUserToAppUserAllDtos(List<AppUser> appUsers);

    AppUserGetDto appUserToAppUserGetDto(AppUser appUser);

    AppUser appUserPostDtoToAppUser(AppUserPostDto appUserPostDto);
}

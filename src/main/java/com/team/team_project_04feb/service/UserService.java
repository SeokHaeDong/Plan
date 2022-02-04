package com.team.team_project_04feb.service;

import com.team.team_project_04feb.dto.UserDTO;
import com.team.team_project_04feb.entity.User;


public interface UserService {
    public Long register(UserDTO dto);

    default User dtoToEntity(UserDTO dto) {
        User entity = User.builder()
                .code(dto.getCode())
                .id(dto.getId())
                .pw(dto.getPw())
                .email(dto.getEmail())
                .nick(dto.getNick())
                .birthday(dto.getBirthday())
                .gender(dto.getGender())
                .status(dto.getStatus())
                .build();
        return entity;
    }

    default UserDTO entityToDto(User entity) {
        UserDTO dto = UserDTO.builder()
                .code(entity.getCode())
                .id(entity.getId())
                .email(entity.getEmail())
                .pw(entity.getPw())
                .nick(entity.getNick())
                .birthday(entity.getBirthday())
                .gender(entity.getGender())
                .status(entity.getStatus())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}

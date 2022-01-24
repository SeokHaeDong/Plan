package com.team.team_project.service;

import com.team.team_project.dto.UserDTO;
import com.team.team_project.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface UserService {
    // default 를 사용하는 이유
    // interface 내에서도  로직이 포함된 메소드를 선언할 수 있게 하기 위해서 .
    // (하위 호환성 때문임)


    // DTO 를 Entity 로 변환
    default User dtoToEntity(UserDTO dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dto.getBirthday(), formatter);
        User entity = User.builder()
                .code(dto.getCode())
                .id(dto.getId())
                .pw(dto.getPw())
                .email(dto.getEmail())
                .nick(dto.getNick())
                .gender(dto.getGender())
                .birthday(date)
                .status(dto.getStatus())
                .build();
        return entity;
    }

    // Entity 를 DTO 로 변경
    default UserDTO entityToDto(User entity) {
        UserDTO dto = UserDTO.builder()
                .code(entity.getCode())
                .id(entity.getId())
                .pw(entity.getPw())
                .email(entity.getEmail())
                .nick(entity.getNick())
                .gender(entity.getGender())
                .birthday(String.valueOf(entity.getBirthday()))
                .status(entity.getStatus())
                .regDate(entity.getRegDate())
                .build();
        return dto;
    }


    // 회원 가입을 위한 method 생성
    public Long join(UserDTO dto);
}

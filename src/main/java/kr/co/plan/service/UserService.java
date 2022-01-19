package kr.co.plan.service;

import kr.co.plan.dto.UserDTO;
import kr.co.plan.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface UserService {
    public Long register(UserDTO dto);

    default User dtoToEntity(UserDTO dto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dto.getUser_birthday(), formatter);
        User entity = User.builder()
                .user_code(dto.getUser_code())
                .user_id(dto.getUser_id())
                .user_pw(dto.getUser_pw())
                .user_email(dto.getUser_email())
                .user_nick(dto.getUser_nick())
                .user_gender(dto.getUser_gender())
                .user_birthday(date)
                .user_exists(dto.getUser_exists())
                .build();
        return entity;
    }

    default UserDTO entityToDto(User entity) {
        UserDTO dto = UserDTO.builder()
                .user_code(entity.getUser_code())
                .user_id(entity.getUser_id())
                .user_pw(entity.getUser_pw())
                .user_email(entity.getUser_email())
                .user_nick(entity.getUser_nick())
                .user_gender(entity.getUser_gender())
                .user_birthday(String.valueOf(entity.getUser_birthday()))
                .user_exists(entity.getUser_exists())
                .user_regDate(entity.getRegDate())
                .build();
        return dto;
    }
}

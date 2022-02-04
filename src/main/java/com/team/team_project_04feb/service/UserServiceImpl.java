package com.team.team_project_04feb.service;

import com.team.team_project_04feb.dto.UserDTO;
import com.team.team_project_04feb.entity.User;
import com.team.team_project_04feb.entity.UserRole;
import com.team.team_project_04feb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override   //회원가입
    public Long register(UserDTO dto) {
        log.info("<<DTO정보>>: "+dto);
        User entity = dtoToEntity(dto);
        log.info("<<Entity정보>>: "+entity);
        entity.addUserRole(UserRole.회원);    //회원 등급 부여
        userRepository.save(entity);
        return entity.getCode();
    }
}

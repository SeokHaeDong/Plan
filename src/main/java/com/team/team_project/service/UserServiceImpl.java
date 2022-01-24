package com.team.team_project.service;

import com.team.team_project.dto.UserDTO;
import com.team.team_project.entity.User;
import com.team.team_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Long join(UserDTO dto) {
        User entity = dtoToEntity(dto);
        userRepository.save(entity);
        return entity.getCode();
    }
}

package kr.co.plan.service;

import kr.co.plan.dto.UserDTO;
import kr.co.plan.entity.User;
import kr.co.plan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public Long register(UserDTO dto) {
        User entity = dtoToEntity(dto);
        repository.save(entity);
        return entity.getUser_code();
    }
}

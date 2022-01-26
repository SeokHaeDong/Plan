package kr.co.plan.plan.service;

import com.querydsl.jpa.impl.JPAQuery;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.QUser;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public Long register(UserDTO dto) {
        User user = DTOToEntity(dto);
        userRepository.save(user);
        return user.getUno();
    }

    @Override
    public String usingCheck(String email) {

        return null;
    }


}

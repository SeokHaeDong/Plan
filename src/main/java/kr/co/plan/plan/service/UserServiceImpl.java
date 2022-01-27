package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public Map<String, Object> register(UserDTO dto) {
        Map<String, Object> status = new HashMap<>();
        status.put("email", false);
        status.put("id", false);
        status.put("nick", false);
        status.put("result", false);

        User user = DTOToEntity(dto);

        // 중복체크 하는 메서드가 3개로 각각의 역할이 중복 됨 동적 쿼리 생성을 통해 하나의 메서드로 만들어
        // 메서드 자체는 하나지만 수행을 여러 번 하는 방식으로 수정 필요
        String result = userRepository.emailCheck(user.getEmail());
        if(result == null){
            status.put("email", true);
        }else{
            status.put("email", false);
        }

        result = userRepository.idCheck(user.getId());
        if(result == null){
            status.put("id", true);
        }else{
            status.put("id", false);
        }

        result = userRepository.nickCheck(user.getNick());
        if(result == null){
            status.put("nick", true);
        }else {
            status.put("nick", false);
        }

        status.get("email");

        if((boolean)(status.get("email")) == true && (boolean)(status.get("id")) == true && (boolean)(status.get("nick")) == true ){
            userRepository.save(user);
            status.put("result", true);
        }else{
            status.put("result", false);
            log.info(status);
        }

        return status;
    }






}

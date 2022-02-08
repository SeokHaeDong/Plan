package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> register(UserDTO dto) {
        Map<String, Object> status = new HashMap<>();
        status.put("email", false);
        status.put("id", false);
        status.put("nick", false);
        status.put("result", false);

        User user = DTOToEntity(dto);

        List<Object[]> dataList = userRepository.dataList();
        for (Object[] list : dataList) {
            String emailLsit = (String) list[0];
            if (user.getEmail() == emailLsit) {
                break;
            } else {
                status.put("email", true);
            }

            String idList = (String) list[1];
            if (user.getId() == idList) {
                break;
            } else {
                status.put("id", true);
            }

            String nickList = (String) list[2];
            if (user.getNick() == nickList) {
                break;
            } else {
                status.put("nick", true);
            }

            if ((boolean) (status.get("email")) == true && (boolean) (status.get("id")) == true && (boolean) (status.get("nick")) == true) {

                String userEncodePassword = passwordEncoder.encode(user.getPw());
                user.setPw(userEncodePassword);
                userRepository.save(user);
                status.put("result", true);
            } else {
                status.put("result", false);
                log.info(status);
            }
        }
        return status;
    }

    @Override
    public Map<String, Object> UserLogin(UserDTO dto) {
        Map<String, Object> status = new HashMap<>();
        status.put("result", false);

        User user = DTOToEntity(dto);

        List<Object[]> userInfo = userRepository.dataList();
        for (Object[] list : userInfo) {
            String emailLsit = (String) list[0];

            String idList = (String) list[1];

            String pwList = (String) list[3];
            if ((emailLsit.equals(user.getEmail()) || idList.equals(user.getId()))) {
                if (passwordEncoder.matches(user.getPw(), pwList)) {
                    status.put("result", true);
                    break;
                } else {
                    log.info("password is wrong");
                }
            } else {
                log.info("email or id was wrong");
            }
        }

        return status;

    }

    @Override
    public void userModifiy(UserDTO dto) {
        User user = userRepository.userInfoUpdate(dto.getId());
        if (user != null) {
            user.changeUser(dto.getNick(), dto.getGender(), dto.getBirthday());
            userRepository.save(user);
        }
    }

    @Override
    public void userRemove(UserDTO dto) {
        userRepository.deleteById(dto.getCode());
    }


}

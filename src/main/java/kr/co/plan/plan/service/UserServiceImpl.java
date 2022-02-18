package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.AnswerDTO;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.Answer;
import kr.co.plan.plan.entity.QUser;
import kr.co.plan.plan.entity.Question;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.AnswerRepository;
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

    private final AnswerRepository answerRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> register(UserDTO dto, AnswerDTO answerDTO) {
        Map<String, Object> status = new HashMap<>();
        status.put("email", false);
        status.put("id", false);
        status.put("nick", false);
        status.put("result", false);

        User user = DTOToEntity(dto);

        // 본인확인 질문에 대한 질문을 선택하고 해당 질문에 대한 qno, 그리고 유저 code 그리고 answer 를 Answer테이블에 저장해야 함
//        List<Object[]> question = new ArrayList<>();
        Question question = userRepository.userRegisterQuestion();

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
                Answer answer = DTOToEntity(answerDTO);
                answerRepository.save(answer);
                userRepository.save(user);
                status.put("result", true);
            } else {
                status.put("result", false);
                log.info(status);
            }



        }
        return status;
    }

    // email , id -> upper, lower로 대소문자 구분 안하도록 해줘야 함
    // 와~ insert 부터 대소문자 구분없이 저장을 하도록 설계를 해야 하네?? 야단이다~~
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

    // 기본키가 user Code 세션에 사용자 정보를 모두 담아 보내야지만 Code 값을 정상적으로 찾아 올수 있음
    // 지금 상태론 아마 명식적으로 code를 부여 해야지만 처리 될듯
    @Override
    public void userRemove(UserDTO dto) {
        userRepository.deleteById(dto.getCode());
    }


}

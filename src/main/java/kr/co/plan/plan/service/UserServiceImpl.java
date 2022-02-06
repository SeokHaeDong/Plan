package kr.co.plan.plan.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import kr.co.plan.plan.config.SecurityConfig;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.QUser;
import kr.co.plan.plan.entity.User;
import kr.co.plan.plan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


//    public UserServiceImpl() {
//        super(User.class);
//    }

    @Override
    public Map<String, Object> register(UserDTO dto) {
        Map<String, Object> status = new HashMap<>();
        status.put("email", false);
        status.put("id", false);
        status.put("nick", false);
        status.put("result", false);

        User user = DTOToEntity(dto);

        QUser quser =QUser.user;


//        JPQLQuery<User> userJPAQuery = from(quser);


//        JPQLQuery<Tuple> tupleJPQLQuery = userJPAQuery.select(email, id, nick);

//        BooleanBuilder booleanBuilder = new BooleanBuilder();
//
//        BooleanExpression expression = quser.code.gt(0L);
//
//        booleanBuilder.and(expression);

        // ㅎㅎ 동적 쿼리 한판 뜨자 언제 까지 안될지 한번 두고 본다
        // 인간인 내가 결국 승리 하게 되어있다 이 자식아 들어와!!!!


        // 중복체크 하는 메서드가 3개로 각각의 역할이 중복 됨 동적 쿼리 생성을 통해 하나의 메서드로 만드는게 관리에 편리 해 보임
        // 메서드 자체는 하나지만 수행을 여러 번 하는 방식으로 수정 필요
        String result = userRepository.emailCheck(user.getEmail());
        // result에 emailCheck 메서드를 통해 결과 값을 받았기 때문에 null 값이면 해당 데이터가 없으므로 사용 가능
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

            String userEncodePassword = passwordEncoder.encode(user.getPw());
            user.setPw(userEncodePassword);
            userRepository.save(user);
            status.put("result", true);
        }else{
            status.put("result", false);
            log.info(status);
        }

        return status;
    }

    @Override
    public boolean UserLogin(User user, String email, String id, String pw) {
        if( (userRepository.emailCheck(email) == email || userRepository.idCheck(id) == id) && passwordEncoder.matches(pw, user.getPw()) ){

            return true;
        }else if( userRepository.emailCheck(email) != email || userRepository.idCheck(id) != id){
            log.info("email is not exists or id is not exists");
            return false;
        }else{
            log.info("pw is not match");
            return false;
        }

    }


}

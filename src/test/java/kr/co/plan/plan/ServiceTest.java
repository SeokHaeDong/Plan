package kr.co.plan.plan;

import kr.co.plan.plan.config.SecurityConfig;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.repository.UserRepository;
import kr.co.plan.plan.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Test
    public void passwordEncode(){

        String userpassword = "1234";

        String encodePassword = passwordEncoder.encode(userpassword);

        assertAll(
                () -> assertNotEquals(userpassword, encodePassword),
                () -> assertTrue(passwordEncoder.matches(userpassword, encodePassword))

        );

    }

//    @Test
    public void userSignUpTest(){
        LocalDate date = LocalDate.parse("2000-01-23");
        UserDTO userDTO = UserDTO.builder()
                .email("test3@naver.com")
                .id("qwer3")
                .pw("1234")
                .nick("tester3")
                .birthday(date)
                .gender("M")
                .status("회원")
                .build();


        Map<String, Object> result = new HashMap<>();
        result = userService.register(userDTO);
        for(String key : result.keySet()){
            Boolean value = (Boolean)result.get(key);
            System.out.println(key + " : " + value);
        }

    }

//    @Test
    public void userLoginTest(){
        UserDTO userDTO = UserDTO.builder()
                .email("test1@naver.com")
                .id("qwer1")
                .pw("1234")
                .build();

        Map<String, Object> result = new HashMap<>();
        result = userService.UserLogin(userDTO);

        System.out.println(result.keySet() + " : " + result.get("result"));

    }

//    @Test
    public void userInfoUpdate(){
        LocalDate date = LocalDate.parse("1999-01-23");

        UserDTO userDTO = UserDTO.builder()
                .id("qwer")
                .nick("변경")
                .birthday(date)
                .gender("M")
                .build();

        userService.userModifiy(userDTO);
        System.out.println(userDTO);
    }

    @Test
    public void userRemove(){

    }


}

package kr.co.plan.plan;

import kr.co.plan.plan.config.SecurityConfig;
import kr.co.plan.plan.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncode(){

        String userpassword = "1234";

        String encodePassword = passwordEncoder.encode(userpassword);

        assertAll(
                () -> assertNotEquals(userpassword, encodePassword),
                () -> assertTrue(passwordEncoder.matches(userpassword, encodePassword))

        );

    }


}

package com.team.team_project_04feb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootTest
public class PasswordTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String password = "1234";
        String enPw = passwordEncoder.encode(password);
        System.out.println("암호화비밀번호: "+enPw);
        boolean matchResult = passwordEncoder.matches(password, enPw);
        System.out.println("비밀번호일치여부: "+matchResult);
    }
}

package com.team.team_project_04feb;

import com.team.team_project_04feb.dto.UserDTO;
import com.team.team_project_04feb.entity.User;
import com.team.team_project_04feb.entity.UserRole;
import com.team.team_project_04feb.repository.UserRepository;
import com.team.team_project_04feb.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //@Test
    public void testRegister() {
        UserDTO userDTO = UserDTO.builder().id("user01").email("user01@test.com")
                .pw("1234").nick("유저01").birthday(LocalDate.parse("2000-01-01"))
                .gender("M").status("가입").build();
        System.out.println("회원정보입력성공:"+userService.register(userDTO));
    }

    //@Test //관리자 계정 추가 (repository 사용)
    public void testAdmin() {
        User user = User.builder().id("admin").email("admin@test.com")
                .pw(passwordEncoder.encode("admin123")).nick("관리자계정")
                .birthday(LocalDate.parse("2022-01-01"))
                .gender("F").status("관리자").build();
        user.addUserRole(UserRole.관리자);
        userRepository.save(user);
    }

    //@Test     //관리자 계정 추가 (service 사용)
    public void createAdmin() {
        UserDTO userDTO = UserDTO.builder()
                .email("admin@todo.com")
                .id("admin")
                .nick("관리자계정")
                .pw(passwordEncoder.encode("admin123"))
                .birthday(LocalDate.parse("1999-01-01"))
                .gender("F")
                .status("관리자")
                .build();
        userService.register(userDTO);

    }


    //@Test
    public void testLogin() {
        Optional<User> result = userRepository.findById("admin");
        User user = result.get();
        System.out.println(user);
    }

    //@Test   //비밀번호 암호화 적용한 (회원) 계정 추가 (service 사용)
    public void userTest(){
        IntStream.rangeClosed(10,99).forEach(i->{
            UserDTO userDTO = UserDTO.builder()
                    .email("user"+i+"@test.com")
                    .id("user"+i)
                    .nick("유저"+i)
                    .pw(passwordEncoder.encode("1234"))
                    .birthday(LocalDate.parse("2000-01-01"))
                    .gender("M")
                    .status("가입")
                    .build();
            userService.register(userDTO);
        });
    }

}

package com.team.team_project;

import com.team.team_project.dto.PlanDTO;
import com.team.team_project.dto.UserDTO;
import com.team.team_project.entity.Friend;
import com.team.team_project.entity.User;
import com.team.team_project.repository.FriendRepository;
import com.team.team_project.repository.UserRepository;
import com.team.team_project.service.PlanService;
import com.team.team_project.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.exceptions.misusing.FriendlyReminderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    @Test
    public void userTest(){
        IntStream.rangeClosed(1,100).forEach(i->{
            User user = User.builder()
                    .email("Test"+i+"@naver.com")
                    .id("test"+i)
                    .nick("테스트"+i)
                    .pw("QWER!@#$"+i*10)
                    .birthday(LocalDate.parse("2000-01-01"))
                    .gender("f")
                    .build();
            userRepository.save(user);
        });
    }

    @Autowired
    private UserService userService;

//    @Test
    public void joinTestByDto(){
        UserDTO dto = UserDTO.builder()
                .id("0123!_12")
                .email("01232!_1t@test.com")
                .nick("테스트맨20123_1")
                .pw("QERWEq22q2R!@#")
                .birthday("1999-12-12")
                .gender("f")
                .build();
        userService.join(dto);
    }

    @Autowired
    private PlanService planService;

//    @Test
    public void makeaplan(){
        PlanDTO dto =PlanDTO.builder()
                .user_code(3L)
                .pno(1L)
                .priority(10L)
                .title("전기뱀장어")
                .description("이해하자")
                .location("장충동")
                .category("족발")
                .share("공개")
                .start(LocalDateTime.parse("2002-01-23T09:30:00"))
                .end(LocalDateTime.parse("2002-01-23T09:30:00"))
                .build();
        System.out.println(planService.makeAPlan(dto));


    }

//    @Test
    public void hundredmakeplan(){
        IntStream.rangeClosed(1,100).forEach(i->{
            PlanDTO dto =PlanDTO.builder()
                    .user_code((long)i)
                    .title("테스트1"+i)
                    .description("T2EST_1"+i)
                    .location("TES2T"+i+"번지")
                    .start(LocalDateTime.parse("2002-01-23T09:30:00"))
                    .end(LocalDateTime.parse("2002-01-23T09:30:00"))
                    .build();
            System.out.println(planService.makeAPlan(dto));
        });
    }
    @Autowired
    private FriendRepository friendRepository;
    @Test
    public void friendTableTestWithoutDto(){
        User user1 = User.builder()
                .code(2L)
                .build();
        User user2 = User.builder()
                .code(3L)
                .build();
        Friend friend = Friend.builder()
                .response(user1)
                .request(user2)
                .build();
        friendRepository.save(friend);

    }
}

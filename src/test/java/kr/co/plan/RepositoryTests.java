package kr.co.plan;

import kr.co.plan.entity.Plan;
import kr.co.plan.entity.User;
import kr.co.plan.repository.FriendRepository;
import kr.co.plan.repository.PlanRepository;
import kr.co.plan.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PlanRepository planRepository;
    @Autowired
    FriendRepository friendRepository;
    @Test
    public void testRegister() {
        User user = User.builder().id("user07").pw("1234").email("user07@test.com")
                .birthday(LocalDate.parse("2000-07-03")).gender("M").nick("테스트07").build();
        System.out.println(userRepository.save(user));
    }

    //@Test
    public void testCreate() {
        User user = User.builder().code(3L).build();
        Plan plan = Plan.builder().title("일정3").description("테스트입니다333").start(LocalDateTime.parse("2022-01-23T09:30:00"))
                .location("서울시 구로구").category("기본").user(user).priority(3).build();
        System.out.println(planRepository.save(plan));
    }

    //@Test
    public void testGetWithUser() {
        Object result = planRepository.getPlanWithUser(1L);
        Object[] arr = (Object[]) result;
        System.out.println(Arrays.toString(arr));
    }



}

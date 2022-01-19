package kr.co.plan;

import kr.co.plan.dto.FriendDTO;
import kr.co.plan.dto.UserDTO;
import kr.co.plan.entity.User;
import kr.co.plan.repository.UserRepository;
import kr.co.plan.service.FriendService;
import kr.co.plan.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class PlanApplicationTests {

    //@Test
    void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;

    //@Test  DTO 사용하는 걸로 바꿔보기
    public void testInsert() {
        User user = User.builder().user_id("user01").user_pw("1234").user_email("user01@test.com")
                .user_birthday(LocalDate.parse("2000-01-01")).user_gender("남자").user_nick("테스트01").build();
        System.out.println(userRepository.save(user));
    }

    @Autowired
    private UserService userService;
    //@Test
    public void testRegister() {
        UserDTO dto = UserDTO.builder().user_id("user02").user_pw("1234").user_email("user02@test.com")
                .user_birthday("2000-01-02").user_gender("남자").user_nick("테스트02").build();
        System.out.println(userService.register(dto));
    }

    @Autowired
    private FriendService friendService;
    //@Test
    public void testRequest() {
        FriendDTO dto = FriendDTO.builder().friend_request(1L).friend_response(2L).friend_status(0)
                .build();
        System.out.println(friendService.request(dto));
    }

    //친구요청 상태 변경


}

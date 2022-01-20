package kr.co.plan;

import kr.co.plan.dto.FriendDTO;
import kr.co.plan.dto.PlanDTO;
import kr.co.plan.service.FriendService;
import kr.co.plan.service.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ServiceTests {
    @Autowired
    private PlanService planService;

    @Autowired
    private FriendService friendService;

    @Test
    public void testCreate() {
        PlanDTO dto = PlanDTO.builder()
                .title("서비스일정33")
                .description("서비스로테스트하기3")
                .location("더조은컴퓨터학원")
                .start(LocalDateTime.parse("2022-01-05T09:30:00"))
                .category("취미")
                .user_code(3L).build();
        Long pno = planService.create(dto);
    }

    @Test
    public void testRequest() {
        FriendDTO dto = FriendDTO.builder().request(2L).response(7L).status("요청중")
                .build();
        System.out.println(friendService.request(dto));
    }
}

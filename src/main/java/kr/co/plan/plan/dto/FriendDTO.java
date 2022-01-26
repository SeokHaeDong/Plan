package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FriendDTO {
    private Long fno;
    private Long request_u;
    private Long response_u;
    private String status;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}

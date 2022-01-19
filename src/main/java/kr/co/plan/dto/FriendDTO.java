package kr.co.plan.dto;


import kr.co.plan.entity.User;
import lombok.*;

import java.time.LocalDateTime;
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    private Long friend_fno;
    private int friend_status;
    private Long friend_request;
    private Long friend_response;
    private LocalDateTime regDate;
    private LocalDateTime modDate;

}

package kr.co.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long user_code;
    private String user_id;
    private String user_pw;
    private String user_email;
    private String user_nick;
    private String user_gender;
    private String user_birthday;
    private int user_exists;
    private LocalDateTime user_regDate;
}

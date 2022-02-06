package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    private Long code;
    private String email;
    private String id;
    private String pw;
    private String nick;
    private LocalDate birthday;
    private String gender;
    private String status;
//    private String role;
    private LocalDateTime regDate;
}

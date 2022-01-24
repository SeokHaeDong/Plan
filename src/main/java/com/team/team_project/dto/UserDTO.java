package com.team.team_project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long code;
    private String id;
    private String pw;
    private String email;
    private String nick;
    private String gender;
    private String birthday;
    private String status;
    private LocalDateTime regDate;
}

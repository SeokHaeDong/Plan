package com.team.team_project_04feb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long code;
    private String id;
    private String email;
    private String pw;
    private String nick;
    private LocalDate birthday;
    private String gender;
    private String status;
    private LocalDateTime regDate, modDate;

}

package com.team.team_project.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PlanDTO {
    private Long pno;
    private Long priority;
    private String title;
    private String location;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private String category;
    private String share;
    private Long user_code;
}

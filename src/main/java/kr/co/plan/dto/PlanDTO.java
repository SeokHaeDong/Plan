package kr.co.plan.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private Long pno;
    private String title;
    private String description;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;
    private String category;
    private String share;
    private int priority;
    private Long user_code;
    private String user_nick;
    private int checkCount;


}

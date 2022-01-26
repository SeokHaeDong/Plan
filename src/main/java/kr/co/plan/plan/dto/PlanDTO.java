package kr.co.plan.plan.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class PlanDTO {
    private Long pno;
    private int priority;
    private String title;
    private String location;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;
    private String category;
    private String share;
    private Long uno;
}

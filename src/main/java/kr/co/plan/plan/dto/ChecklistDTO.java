package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChecklistDTO {
    private Long cno;
    private Long code;
    private Long pno;
    private String todo;
    private String done;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}

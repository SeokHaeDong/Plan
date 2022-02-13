package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnswerDTO {
    private Long ano;
    private Long code;
    private Long qno;
    private String answer;

}

package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelfCheckDTO {
    private Long sno;
    private Long uno;
    private Long qno;
    private String answer;

}

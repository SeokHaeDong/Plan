package kr.co.plan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShareDTO {
    private Long sno;
    private Long uno;
    private Long pno;
}

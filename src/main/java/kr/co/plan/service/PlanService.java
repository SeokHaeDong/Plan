package kr.co.plan.service;

import kr.co.plan.dto.PlanDTO;
import kr.co.plan.entity.Plan;
import kr.co.plan.entity.User;

public interface PlanService {

    Long create(PlanDTO dto);

    default Plan dtoToEntity(PlanDTO dto) {
        User user = User.builder().code(dto.getUser_code()).build();
        Plan plan = Plan.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .start(dto.getStart())
                .end(dto.getEnd())
                .category(dto.getCategory())
                .share(dto.getShare())
                .priority(dto.getPriority())
                .user(user)
                .build();
        return plan;
    }

    default PlanDTO entityToDTO(Plan plan, User user, Long checkCount) {
        PlanDTO dto = PlanDTO.builder()
                .pno(plan.getPno())
                .title(plan.getTitle())
                .description(plan.getDescription())
                .location(plan.getLocation())
                .start(plan.getStart())
                .end(plan.getEnd())
                .category(plan.getCategory())
                .share(plan.getShare())
                .priority(plan.getPriority())
                .user_code(user.getCode())
                .user_nick(user.getNick())
                .checkCount(checkCount.intValue())
                .build();
        return dto;
    }
}

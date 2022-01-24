package com.team.team_project.service;

import com.team.team_project.dto.PlanDTO;
import com.team.team_project.entity.Plan;
import com.team.team_project.entity.User;

public interface PlanService {

    default Plan dtoToEntity(PlanDTO dto){
        User user = User.builder()
                .code(dto.getUser_code())
                .build();
        Plan plan = Plan.builder()
                .pno(dto.getPno())
                .priority(dto.getPriority())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .share(dto.getShare())
                .location(dto.getLocation())
                .start(dto.getStart())
                .end(dto.getEnd())
                .user(user)
                .build();
        return plan;
    }

    default PlanDTO entityToDTO(Plan plan,User user){
        PlanDTO dto =PlanDTO.builder()
                .user_code(user.getCode())
                .pno(plan.getPno())
                .priority(plan.getPriority())
                .title(plan.getTitle())
                .description(plan.getDescription())
                .location(plan.getLocation())
                .category(plan.getCategory())
                .share(plan.getShare())
                .start(plan.getStart())
                .end(plan.getEnd())
                .build();
        return dto;
    }

     public Long makeAPlan(PlanDTO dto);
}

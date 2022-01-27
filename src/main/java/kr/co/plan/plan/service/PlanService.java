package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.PlanDTO;
import kr.co.plan.plan.dto.UserDTO;
import kr.co.plan.plan.entity.Plan;
import kr.co.plan.plan.entity.User;

public interface PlanService {

    default Plan DTOToEntity(PlanDTO dto){
        User user = User.builder().uno(dto.getUno()).build();
        Plan plan = Plan.builder().pno(dto.getPno()).priority(dto.getPriority()).title(dto.getTitle()).location(dto.getLocation()).start(dto.getStart()).end(dto.getEnd()).description(dto.getDescription()).category(dto.getCategory()).share(dto.getShare()).user(user).build();

        return plan;

    }

    default PlanDTO EntityToDTO(Plan plan, User user){

        PlanDTO planDTO = PlanDTO.builder().pno(plan.getPno()).priority(plan.getPriority()).title(plan.getTitle()).location(plan.getLocation()).start(plan.getStart()).end(plan.getEnd()).description(plan.getDescription()).category(plan.getCategory()).share(plan.getShare()).uno(user.getUno()).build();

        return planDTO;
    }

}

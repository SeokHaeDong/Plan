package com.team.team_project.service;


import com.team.team_project.dto.PlanDTO;
import com.team.team_project.entity.Plan;
import com.team.team_project.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

@Log4j2
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;



    @Override
    public Long makeAPlan(PlanDTO dto) {
        Plan entity = dtoToEntity(dto);
        planRepository.save(entity);
        return entity.getPno();
    }
}

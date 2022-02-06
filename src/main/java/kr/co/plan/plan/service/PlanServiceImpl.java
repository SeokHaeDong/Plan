package kr.co.plan.plan.service;

import kr.co.plan.plan.dto.PlanDTO;
import kr.co.plan.plan.entity.Plan;
import kr.co.plan.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;


    @Override
    public void NewPlan(PlanDTO planDTO) {
        Plan plan = DTOToEntity(planDTO);
        planRepository.save(plan);
        log.info("NewPlan insert");
    }
}

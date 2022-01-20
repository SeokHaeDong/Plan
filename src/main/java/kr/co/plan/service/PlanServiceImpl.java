package kr.co.plan.service;

import kr.co.plan.dto.PlanDTO;
import kr.co.plan.entity.Plan;
import kr.co.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlanServiceImpl implements PlanService{
    private final PlanRepository planRepository;

    @Override
    public Long create(PlanDTO dto) {
        Plan entity = dtoToEntity(dto);
        planRepository.save(entity);
        return entity.getPno();
    }
}

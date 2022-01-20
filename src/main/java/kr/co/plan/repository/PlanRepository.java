package kr.co.plan.repository;

import kr.co.plan.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    //@Query("select Plan, Plan.user from Plan left join Plan.user where Plan.pno=:pno")
    @Query("select p, u from Plan p left join p.user u where p.pno=:pno")
    Object getPlanWithUser(@Param("pno") Long pno);
}

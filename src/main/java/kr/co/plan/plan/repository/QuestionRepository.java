package kr.co.plan.plan.repository;

import kr.co.plan.plan.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question, Long> {
}

package kr.co.plan.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanApplication.class, args);
    }

}

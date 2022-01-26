package kr.co.plan.plan.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qno;

    @Column(nullable = false)
    private String context;

    @Column(nullable = false)
    private String answer;

}

package kr.co.plan.plan.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@ToString(exclude = {"user", "question"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SelfCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "uno")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "qno")
    private Question question;

}

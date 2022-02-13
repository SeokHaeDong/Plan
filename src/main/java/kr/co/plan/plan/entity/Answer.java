package kr.co.plan.plan.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@ToString(exclude = {"user", "question"})
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ano;

    @Column(nullable = false)
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "code")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "qno")
    private Question question;

}

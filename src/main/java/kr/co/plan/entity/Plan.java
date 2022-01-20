package kr.co.plan.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
@DynamicInsert
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column(length = 100, nullable = false)
    private String title;

    //텍스트 어떻게 하지?
    private String description;

    @Column(length = 100)
    private String location;

    @Column(nullable = false)
    private LocalDateTime start;

    private LocalDateTime end;

    @Column(length = 20)
    private String category;

    @Column(columnDefinition = "varchar(3) default '비공개'")
    private String share;

    private int priority;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeDescription(String description) {
        this.description = description;
    }


}

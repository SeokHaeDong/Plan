package kr.co.plan.plan.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "user")
@DynamicInsert
@DynamicUpdate
public class Plan{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    @Column
    private int priority;

    @Column(nullable = false)
    private String title;

    private String location;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'No Category'")
    private String category;

    @Column(columnDefinition = "varchar(4) default '비공개'")
    private String share;

//    @Transactional 사용, 미 사용시 관련된 Entity들의 정보를 불러 올 수 없음
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name="uno")
    private User user;

}

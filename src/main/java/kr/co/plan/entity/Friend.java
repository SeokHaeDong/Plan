package kr.co.plan.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
@ToString(exclude = {"request","response"})
public class Friend extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @Column(columnDefinition = "varchar(5) default '요청중'")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User request;

    @ManyToOne(fetch = FetchType.LAZY)
    private User response;

}

package com.team.team_project.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude="user")
@DynamicInsert
// 특정 필드 "user" 를 결과에서 제외시키는 거 가능
public class Plan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pno;

    private Long priority;

    @Column(length = 100 , nullable = false)
    private String title;

    private String location;

    private String description;

    @Column(nullable = false)
    private LocalDateTime start;

    @Column(nullable = false)
    private LocalDateTime end;

    @Column(length = 20 , columnDefinition = "varchar(20) default 'No Category'")
    private String category;

    @Column(length= 20 , columnDefinition = "varchar(20) check (share in ('공개','비공개')) default '비공개'")
    private String share;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public void changePriority(Long priority){
        this.priority=priority;
    }
    public void  changeTitle(String title){
        this.title=title;
    }
    public void changeLocation(String location){
        this.location=location;
    }
    public void changeDescription(String description){
        this.description=description;
    }
    public void changeStart(LocalDate start){
        this.start= LocalDateTime.from(start);
    }
    public void changeEnd(LocalDate end){
        this.end= LocalDateTime.from(end);
    }
    public void changeShare(String share){
        this.share=share;
    }
    public void changeCategory(String category){
        this.category=category;
    }
}




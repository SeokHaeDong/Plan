package com.team.team_project.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"request","response"})
@DynamicInsert
public class Friend extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    @Column(columnDefinition = "varchar(5) check (status in ('요청중','수락','거절','차단')) default '요청중'")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User request;

    @ManyToOne(fetch = FetchType.LAZY)
    private User response;

    public void changeStatus(String status){
        this.status=status;
    }
}

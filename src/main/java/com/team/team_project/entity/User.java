package com.team.team_project.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EntityListeners(value={AuditingEntityListener.class})
@Table(name="User",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email","id","nick"})})
@DynamicInsert
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long code;

    @Column(name="id", length = 255, nullable = false)
    private String id;

    @Column(name="email",length = 255, nullable = false)
    private String email;

    @Column(name="pw",length = 255, nullable = false)
    private String pw;

    @Column(name="nick",length = 50, nullable = false)
    private String nick;

    @Column(name="birthday",nullable = false)
    private LocalDate birthday;

    @Column(name="gender",columnDefinition = "varchar(2) check (gender in ('m','f'))" ,nullable = false)
    private String gender;

    @Column(columnDefinition = " varchar(5) default '회원'")
    private String status;


    public void changePw(String user_pw){
        this.pw = user_pw;
    }

    public void changeNick(String nick){
        this.nick = nick;
    }

    public void changeGender(String gender){
        this.gender = gender;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    public void changeBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

}

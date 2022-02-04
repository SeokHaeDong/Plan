package com.team.team_project_04feb.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String status;


    public void changePw(String pw){
        this.pw = pw;
    }

    public void changeNick(String nick){
        this.nick = nick;
    }

    public void changeBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void changeGender(String gender){
        this.gender = gender;
    }

    public void changeStatus(String status) {
        this.status = status;
    }

    //security 권한 사용
    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();
    public void addUserRole(UserRole userRole){
        roleSet.add(userRole);
    }

}

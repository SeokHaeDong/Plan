package kr.co.plan.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_code;
    @Column(length = 200, nullable = false)
    private String user_id;
    @Column(length = 200, nullable = false)
    private String user_email;
    @Column(length = 200, nullable = false)
    private String user_pw;
    @Column(length = 50, nullable = false)
    private String user_nick;
    @Column(nullable = false)
    private LocalDate user_birthday;
    @Column(length = 2, nullable = false)
    private String user_gender;
    @Column
    private int user_exists;

    public void changeUser_pw(String user_pw){
        this.user_pw = user_pw;
    }

    public void changeUser_nick(String user_nick){
        this.user_nick = user_nick;
    }

    public void changeUser_gender(String user_gender){
        this.user_gender = user_gender;
    }

    public void changeUser_exists(int user_exists) {
        this.user_exists = user_exists;
    }

    public void changeUser_birthday(LocalDate user_birthday) {
        this.user_birthday = user_birthday;
    }

}

package kr.co.plan.plan.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@DynamicInsert
@DynamicUpdate
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uno;

    @NotBlank(message = "이메일을 입력해주세요.")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "아이디를 입력해주세요.")
    @Column(nullable = false, unique = true)
    private String id;

    @NotBlank(message = "비밀번호는 공백일 수 없습니다.")
    @Column(nullable = false)
    private String pw;

    @NotBlank(message = "사용하실 닉네임을 입력해주세요.")
    @Column(nullable = false, unique = true)
    private String nick;

    private LocalDate birthday;

    @Column(columnDefinition = "varchar(2) check (gender in ('M', 'F'))")
    private String gender;

    @Column(columnDefinition = "varchar(5) default '회원'")
    private String status;

    @Column(columnDefinition = "varchar(10) default '일반회원'", nullable = false)
    private String role;

}

package kr.co.plan.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@DynamicInsert
@DynamicUpdate
@ToString
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, length = 30, unique = true)
    private String nick;

    @Column(nullable = false, length = 3)
    private String gender;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(columnDefinition = "varchar(3) default '가입'")
    private String exist;

    private boolean fromSocial;

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<UserRole> roleSet = new HashSet<>();

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super();
    }

    public void addUserRole(UserRole userRole) {
        roleSet.add(userRole);
    }
    
}

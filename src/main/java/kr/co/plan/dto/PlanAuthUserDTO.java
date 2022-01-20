package kr.co.plan.dto;

import org.springframework.security.core.userdetails.User; //엔티티와 다름
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;


import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class PlanAuthUserDTO extends User {
    private String email;
    private String id;
    private boolean fromSocial;
    private String password;
    private Map<String, Object> attr;

    public PlanAuthUserDTO (String username, String password,
                              Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
        this(username,password, authorities);
        this.attr = attr;
    }

    public PlanAuthUserDTO (String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.password = password;

    }
}

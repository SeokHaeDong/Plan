package kr.co.plan.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;


import java.util.Collection;
import java.util.Map;

@Log4j2
@Getter
@Setter
@ToString
public class PlanAuthUser extends User implements OAuth2User {
    private String email;

    private String password;

    private String id;

    private boolean fromSocial;

    private Map<String, Object> attr;

    public PlanAuthUser(String username, String password,
                          Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
        this(username,password, authorities);
        this.attr = attr;
    }


    public PlanAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;

    }

    //모든 속성의 값을 리턴하는 메서드
    @Override
    public Map<String, Object> getAttributes(){
        return this.attr;
    }

    @Override
    public String getName() {
        return null;
    }
}

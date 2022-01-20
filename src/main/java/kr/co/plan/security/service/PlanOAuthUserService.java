package kr.co.plan.security.service;

import kr.co.plan.entity.User;
import kr.co.plan.entity.UserRole;
import kr.co.plan.repository.UserRepository;
import kr.co.plan.security.dto.PlanAuthUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class PlanOAuthUserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private User saveSocialMember(String email){
        //기존에 동일한 이메일로 가입한 회원이 있는 경우에는 그대로 조회만
        Optional<User> result = userRepository.findByEmail(email,false);
        if(result.isPresent()){
            return result.get();
        }

        User user = User.builder()
                .email(email)
                .pw( passwordEncoder.encode("1111") )
                .fromSocial(true)
                .build();
        user.addUserRole(UserRole.MEMBER);
        userRepository.save(user);
        return user;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String clientName = userRequest.getClientRegistration().getClientName();

        log.info("clientName: " + clientName);
        log.info(userRequest.getAdditionalParameters());

        OAuth2User oAuth2User =  super.loadUser(userRequest);

        log.info("==============================");
        oAuth2User.getAttributes().forEach((k,v) -> {
            log.info(k +":" + v);
        });
        //구글에서 접속한 경우의 email을 가져오기
        String email = null;
        if(clientName.trim().toLowerCase().indexOf("google") >= 0){
            email = oAuth2User.getAttribute("email");
        }

        User user = saveSocialMember(email);

        PlanAuthUser planAuthUser = new PlanAuthUser(
                user.getEmail(),
                user.getPw(),
                user.getRoleSet().stream().map(
                                role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
                        .collect(Collectors.toList()),
                oAuth2User.getAttributes()
        );

        return planAuthUser;
    }



    }

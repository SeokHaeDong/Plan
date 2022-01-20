package kr.co.plan.security.service;


import kr.co.plan.dto.PlanAuthUserDTO;
import kr.co.plan.entity.User;
import kr.co.plan.repository.UserRepository;
import kr.co.plan.security.dto.PlanAuthUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class PlanUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("ClubUserDetailsService loadUserByUsername " + username);
        User user = userRepository.findByEmail(username, false).get();
        log.info("-----------------------------");

        PlanAuthUser planAuthUser = new PlanAuthUser(
                user.getEmail(),
                user.getPw(),
                user.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                        .collect(Collectors.toSet())
        );
        planAuthUser.setId(user.getId());
        planAuthUser.setFromSocial(user.isFromSocial());
        return planAuthUser;
    }


}


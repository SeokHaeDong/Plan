package com.team.team_project_04feb.security.service;

import com.team.team_project_04feb.entity.User;
import com.team.team_project_04feb.repository.UserRepository;
import com.team.team_project_04feb.security.dto.AuthMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();
        log.info("로그인요청유저: "+user);
        AuthMember authMember = new AuthMember(
                user.getId(),
                user.getPw(),
                user.getRoleSet().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
                        .collect(Collectors.toSet())
        );
        authMember.setNick(user.getNick());
        return authMember;

    }
}

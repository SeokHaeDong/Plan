package com.team.team_project_04feb.config;


import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // sample디렉토리에 테스트 페이지 생성
        httpSecurity.authorizeRequests().antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/admin").hasRole("관리자")
                .antMatchers("/sample/member").hasRole("회원")
                .antMatchers("/admin").hasRole("관리자")
                .antMatchers("/main").hasRole("회원");
        //접근권한 문제있을 경우 이동할 페이지 -> 로그인 페이지
        httpSecurity.formLogin().loginPage("/loginform").loginProcessingUrl("/login");

        //크로스사이트요청위조-비활성화
        httpSecurity.csrf().disable();

        //로그아웃설정
        httpSecurity.logout().logoutUrl("/logout").invalidateHttpSession(true)
                .logoutSuccessUrl("/main"); //로그아웃 후 이동할 페이지
    }
}

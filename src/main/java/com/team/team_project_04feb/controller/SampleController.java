package com.team.team_project_04feb.controller;

import com.team.team_project_04feb.security.dto.AuthMember;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/sample/")
public class SampleController {
    @GetMapping("/all")
    public void exAll(){
        log.info("exAll..........");
    }

    @GetMapping("/member")
    public void exMember(@AuthenticationPrincipal AuthMember authMember){
        log.info("exMember..........");
        log.info(authMember);
    }

    @GetMapping("/admin")
    public void exAdmin(){
        log.info("exAdmin..........");
    }


}

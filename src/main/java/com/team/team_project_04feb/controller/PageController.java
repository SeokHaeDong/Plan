package com.team.team_project_04feb.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class PageController {
    @GetMapping({"/","/main"})
    public String mainpage(){
        return "/main";
    }

    //관리자페이지
    @GetMapping("/admin")
    public String adminpage(){
        return "/admin";
    }

    //로그인페이지
    @GetMapping("/loginform")
    public void login(String error, String logout, Model model) {
        log.info("에러: "+error);
//        log.info("로그아웃: "+logout);
        if(error != null) {
            model.addAttribute("error","로그인이 불가능합니다");
        }
//        if(logout != null) {
//            model.addAttribute("logout","로그아웃 하였습니다");
//        }
    }

    //로그아웃페이지
    @GetMapping("/logout")
    public String logout() {
        System.out.println("커스텀 로그아웃");
        return "/main";
    }
}

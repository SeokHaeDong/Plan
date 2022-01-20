package kr.co.plan.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/customlogout")
    public void logout() {
        System.out.println("custom logout");
    }

}

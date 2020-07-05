package com.b.bbb.controller;

import com.b.bbb.domain.LoginDTO;
import com.b.bbb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String index(Model model){
        System.out.println("memberList 컨트롤러 : " + memberService.memberList());
        model.addAttribute("memberList", memberService.memberList());
        return "index";
    }

    @GetMapping("/join")
    public String join(){

        return "join";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    @PostMapping("/rest/login")
    public String login(LoginDTO loginDTO, HttpSession httpSession, Model model){
        System.out.println("login Controller : " + memberService.login(loginDTO));
        httpSession.setAttribute("user", memberService.login(loginDTO));
        model.addAttribute("member", httpSession.getAttribute("user"));
        return "redirect:/";


    }

}

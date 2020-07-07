package com.b.bbb.controller;

import com.b.bbb.domain.LoginDTO;
import com.b.bbb.service.BoardService;
import com.b.bbb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;

    @GetMapping("/")
    public String index(Model model, HttpSession httpSession){
        System.out.println("memberList 컨트롤러 : " + memberService.memberList());
        model.addAttribute("memberList", memberService.memberList());

        System.out.println("세션 정보 : " + httpSession.getAttribute("user"));
        model.addAttribute("member", httpSession.getAttribute("user"));

        model.addAttribute("boardList", boardService.boardList());
        return "index";

    }

    @GetMapping("/join")
    public String join(Model model, HttpSession httpSession){
        System.out.println("세션 정보 : " + httpSession.getAttribute("user"));
        model.addAttribute("member", httpSession.getAttribute("user"));
        return "join";
    }

    @GetMapping("/login")
    public String loginPage(Model model, HttpSession httpSession){
        System.out.println("세션 정보 : " + httpSession.getAttribute("user"));
        model.addAttribute("member", httpSession.getAttribute("user"));
        return "login";
    }

    @PostMapping("/rest/login")
    public String login(LoginDTO loginDTO, HttpSession httpSession, Model model){
        System.out.println("login Controller : " + memberService.login(loginDTO));
        httpSession.setAttribute("user", memberService.login(loginDTO));
        model.addAttribute("member", httpSession.getAttribute("user"));
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/write")
    public String write(Model model, HttpSession httpSession){
        System.out.println("세션 정보 : " + httpSession.getAttribute("user"));
        model.addAttribute("member", httpSession.getAttribute("user"));
        return "/write";
    }

    @GetMapping("/select/{bno}")
    public String select(@PathVariable("bno") long bno, Model model, HttpSession httpSession){
        model.addAttribute("member", httpSession.getAttribute("user"));
        model.addAttribute("select", boardService.select(bno));
        boardService.readcount(bno);
        System.out.println("세션 정보 : " + httpSession.getAttribute("user"));

        model.addAttribute("replyList", boardService.replyList(bno));

        return "/select";
    }

    @GetMapping("/update/{bno}")
    public String update(@PathVariable("bno") long bno, Model model, HttpSession httpSession){
        model.addAttribute("member", httpSession.getAttribute("user"));
        model.addAttribute("select", boardService.select(bno));
        System.out.println("Controller : 게시글 업데이트 요청");
        return "/update";
    }

}

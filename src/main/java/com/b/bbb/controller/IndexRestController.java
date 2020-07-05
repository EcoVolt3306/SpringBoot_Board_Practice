package com.b.bbb.controller;

import com.b.bbb.domain.JoinDTO;
import com.b.bbb.domain.WriteDTO;
import com.b.bbb.service.BoardService;
import com.b.bbb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestController {
    @Autowired
    MemberService memberService;
    @Autowired
    BoardService boardService;

    @PostMapping("/rest/join")
    public void join(JoinDTO joinDTO){
        System.out.println("Join RestController : " + joinDTO.toString());
        memberService.join(joinDTO);
    }

    @PostMapping("/rest/write")
    public void write(WriteDTO writeDTO){
        System.out.print("Rest컨트롤러 - writeDTO 사용!");
        boardService.write(writeDTO);
    }


}

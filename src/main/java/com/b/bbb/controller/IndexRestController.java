package com.b.bbb.controller;

import com.b.bbb.domain.*;
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

    @PostMapping("/rest/reco")
    public void reco(RecoDTO recoDTO){
        System.out.println("Reco Rest Controller");
        boardService.reco(recoDTO);
    }

    @PostMapping("/rest/delete")
    public void delete(DeleteDTO deleteDTO){
        System.out.println("Delete!");
        boardService.delete(deleteDTO);
    }

    @PostMapping("/rest/update")
    public void update(UpdateDTO updateDTO){
        System.out.print("Controller : 게시글 수정 쿼리 실행!");
        boardService.update(updateDTO);
    }

    @PostMapping("/rest/reply")
    public void reply(ReplyDTO replyDTO){
        System.out.print("Controller : 댓글 처리!");
        boardService.reply(replyDTO);
    }


}

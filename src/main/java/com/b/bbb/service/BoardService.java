package com.b.bbb.service;

import com.b.bbb.domain.*;
import com.b.bbb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Service
public class BoardService {
    @Autowired(required = false)
    BoardMapper boardMapper;

    public void write(WriteDTO writeDTO){
        boardMapper.write(writeDTO);
    }

    public ArrayList<BoardListDTO> boardList(){
        return boardMapper.boardList();
    }

    public SelectDTO select(long bno){
        System.out.println("Select 서비스 : " + boardMapper.select(bno));
        return boardMapper.select(bno);
    }

    public void readcount(ReadcountDTO readcountDTO, HttpSession httpSession){
        System.out.println("readcount 서비스");
        //boardMapper.readcount(readcountDTO);
        //boardMapper.procount(readcountDTO);
        System.out.println("왜판별이 안되노........."+readcountDTO);
        /*
        if(readcountDTO.getType().equals("false")) {
            System.out.println("일반");
            boardMapper.readcount(readcountDTO);
        }
        else if(readcountDTO.getType().equals("True")) {
            System.out.println("프로");
            boardMapper.procount(readcountDTO);
        }
         */

        if(httpSession.getAttribute("type").equals("false")) {
            System.out.println("일반");
            boardMapper.readcount(readcountDTO);
        }
        else if(httpSession.getAttribute("type").equals("True")) {
            System.out.println("프로");
            boardMapper.procount(readcountDTO);
        }

        System.out.println(readcountDTO.getType());

    }

    public void reco(RecoDTO recoDTO){
        boardMapper.userreco(recoDTO);
    }

    public void delete(DeleteDTO deleteDTO){
        boardMapper.delete(deleteDTO);
    }

    public void update(UpdateDTO updateDTO){
        boardMapper.update(updateDTO);
    }

    public void reply(ReplyDTO replyDTO){
        boardMapper.reply(replyDTO);
    }

    public ArrayList<ReplyListDTO> replyList(long bno){
        return boardMapper.replyList(bno);
    }

}

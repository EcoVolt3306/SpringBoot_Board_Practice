package com.b.bbb.service;

import com.b.bbb.domain.*;
import com.b.bbb.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public void readcount(long bno){
        boardMapper.readcount(bno);
    }

    public void reco(RecoDTO recoDTO){
        if(recoDTO.getType().equals("일반")) {
            boardMapper.userreco(recoDTO);
        }
        else if(recoDTO.getType().equals("전문가")) {
            boardMapper.proreco(recoDTO);
        }
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

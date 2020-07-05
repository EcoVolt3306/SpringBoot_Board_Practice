package com.b.bbb.service;

import com.b.bbb.domain.BoardListDTO;
import com.b.bbb.domain.WriteDTO;
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
}

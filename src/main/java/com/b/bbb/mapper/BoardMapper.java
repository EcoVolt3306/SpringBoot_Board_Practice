package com.b.bbb.mapper;

import com.b.bbb.domain.BoardListDTO;
import com.b.bbb.domain.SelectDTO;
import com.b.bbb.domain.WriteDTO;

import java.util.ArrayList;

public interface BoardMapper {
    void write(WriteDTO writeDTO);
    ArrayList<BoardListDTO> boardList();
    SelectDTO select(long bno);
    void readcount(long bno);
}

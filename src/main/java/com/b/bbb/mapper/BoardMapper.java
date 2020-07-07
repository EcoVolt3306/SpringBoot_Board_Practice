package com.b.bbb.mapper;

import com.b.bbb.domain.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BoardMapper {
    void write(WriteDTO writeDTO);
    ArrayList<BoardListDTO> boardList();
    SelectDTO select(long bno);
    void readcount(long bno);

    void userreco(RecoDTO recoDTO);
    void proreco(RecoDTO recoDTO);

    void delete(DeleteDTO deleteDTO);

    void update(UpdateDTO updateDTO);

    void reply(ReplyDTO replyDTO);
    ArrayList<ReplyListDTO> replyList(long bno);
}
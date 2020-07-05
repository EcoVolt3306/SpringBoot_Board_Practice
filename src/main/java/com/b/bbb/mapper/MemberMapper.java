package com.b.bbb.mapper;

import com.b.bbb.domain.JoinDTO;
import com.b.bbb.domain.LoginDTO;
import com.b.bbb.domain.MemberListDTO;

import java.util.ArrayList;

public interface MemberMapper {
    void join(JoinDTO joinDTO);
    ArrayList<MemberListDTO> memberList();
    LoginDTO login(LoginDTO loginDTO);
}

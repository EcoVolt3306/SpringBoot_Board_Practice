package com.b.bbb.service;

import com.b.bbb.domain.JoinDTO;
import com.b.bbb.domain.LoginDTO;
import com.b.bbb.domain.MemberListDTO;
import com.b.bbb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired(required = false)
    MemberMapper memberMapper;

    public void join(JoinDTO joinDTO){
        memberMapper.join(joinDTO);
    }

    public ArrayList<MemberListDTO> memberList(){
        System.out.println("memberList : " + memberMapper.memberList());
        return memberMapper.memberList();
    }

    public LoginDTO login(LoginDTO loginDTO){
        System.out.println("login Service : " + memberMapper.login(loginDTO));
        return memberMapper.login(loginDTO);
    }

}

package com.b.bbb.service;

import com.b.bbb.domain.JoinDTO;
import com.b.bbb.domain.LoginDTO;
import com.b.bbb.domain.MemberListDTO;
import com.b.bbb.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired(required = false)
    MemberMapper memeberMapper;

    public void join(JoinDTO joinDTO){
        memeberMapper.join(joinDTO);
    }

    public ArrayList<MemberListDTO> memberList(){
        System.out.println("memberList : " + memeberMapper.memberList());
        return memeberMapper.memberList();
    }

    public LoginDTO login(LoginDTO loginDTO){
        System.out.println("login Service : " + memeberMapper.login(loginDTO));
        return memeberMapper.login(loginDTO);
    }

}

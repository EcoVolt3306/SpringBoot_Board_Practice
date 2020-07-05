package com.b.bbb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MemberListDTO {
    private long mno;
    private String id;
    private String name;
    private String type;
    private Date regdate;
}

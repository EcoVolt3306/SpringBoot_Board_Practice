package com.b.bbb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SelectDTO {
    private long bno;
    private String title;
    private String content;
    private String writer;
    private Date regdate;
    private int readcount;
    private int userreco;
    private int proreco;
}

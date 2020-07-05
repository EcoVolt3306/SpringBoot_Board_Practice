package com.b.bbb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardListDTO {
    private long bno;
    private String title;
    private String writer;
    private Date regdate;
    private int readcount;
    private int userreco;
    private int proreco;
}

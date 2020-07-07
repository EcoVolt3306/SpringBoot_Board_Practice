package com.b.bbb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ReplyListDTO {
    private long rno;
    private String re_writer;
    private String re_content;
    private Date re_date;
    private long bno;
    private long mno;

}

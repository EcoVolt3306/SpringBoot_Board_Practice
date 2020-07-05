package com.b.bbb.domain;

import lombok.Data;

@Data
public class WriteDTO {
    private long mno;
    private String title;
    private String content;
    private String writer;
}

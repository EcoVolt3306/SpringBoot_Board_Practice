package com.b.bbb.domain;

import lombok.Data;

@Data
public class LoginDTO {
    private long mno;
    private String id;
    private String password;
    private String name;
    private String type;
}

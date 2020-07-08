select * from tabs;

/*테이블 제거 쿼리*/
drop sequence seq_b_reply_rno;
drop sequence seq_b_board_bno;
drop sequence seq_b_member_mno;

drop view view_b_reply;
drop view view_b_board;
drop view view_b_member;

drop table b_reply;
drop table b_board;
drop table b_member;

/*테이블 생성*/
create table b_member(
                         mno number not null,
                         id varchar2(100) not null,
                         password varchar2(200) not null,
                         name varchar2(50) not null,
                         type varchar2(20) not null,
                         regdate date,
                         constraint b_member_mno_pk primary key(mno)
);

create table b_board(
                        bno number,
                        title varchar2(200) not null,
                        content varchar2(2000) not null,
                        writer varchar2(100) not null,
                        regdate date,
                        readcount number,
                        userreco number,
                        proreco number,
                        mno number,
                        constraint b_board_bno_pk primary key (bno),
                        constraint b_board_mno_fk foreign key(mno) references b_member(mno)
                            on delete cascade
);

create table b_reply(
                        rno number,
                        re_writer varchar2(100) not null,
                        re_content varchar2(500) not null,
                        re_date date,
                        mno number,
                        bno number,
                        constraint b_reply_rno_pk primary key (rno),
                        constraint b_reply_mno_fk foreign key(mno) references b_member(mno),
                        constraint b_reply_bno_fk foreign key(bno) references b_board(bno)
                            on delete cascade
);

create view view_b_member
as select * from b_member;

create view view_b_board
as select * from b_board;

create view view_b_reply
as select * from b_reply;

create sequence seq_b_member_mno
    increment by 1
    start with 1;

create sequence seq_b_board_bno
    increment by 1
    start with 1;

create sequence seq_b_reply_rno
    increment by 1
    start with 1;

commit;

/* 조회 */
select * from b_member;
select * from b_board;
select * from view_b_reply;
drop table gbook;
drop sequence seq_gbook;

create table gbook (
	num number not null,
	title varchar2(50) not null,
	author varchar2(50) not null,
	email varchar2(50) not null,
	content long,
	password varchar2(20) not null,
	writeday date not null,
	readnum number
);
CREATE SEQUENCE seq_gbook START WITH 1 INCREMENT BY 1 ; 

commit;

--------------

drop table Member cascade constraints;
drop table Feed cascade constraints;
drop sequence Feed_id_seq;



create table Member (
   id varchar2(50) not null,
    info clob,
    name varchar2(50) not null,
    password varchar2(20) not null,
    primary key (id)
);

create table Feed (
   fno number(10,0) not null,
    content clob,
    thumbUp number(10,0) not null,
    title varchar2(50) not null,
    writeday date not null,
    memberId varchar2(50),
    primary key (fno),
    CONSTRAINT feed_fk FOREIGN KEY(memberId) REFERENCES Member(id)
);

create sequence Feed_id_seq start with 1 increment by 1;

insert into member m values('12','12','12','12');
insert into feed f values(1,'12',0,'12',sysdate,'12');





--alter table Feed 
--   add constraint feed_fk
--   foreign key (memberId)
--   references Member(
-- select
--    fno,
--    content,
--    thumbUp,
--    memberId,
--    title,
--    writeday
--from
--    Feed
--order by
--    fno);
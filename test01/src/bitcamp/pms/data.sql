insert into TEACHERS(TNM,EMAIL,PWD,TEL) values('엄진영', 'eom@test.com', '1111', '999-9999');
insert into MANAGERS(MGNM,EMAIL,PWD,TEL) values('김용', 'kim@test.com', '1111', '888-8888');
insert into CLASSES(SUB,NUM,TNO,MGNO,ROOM) values('자바', '80', '1', '1', '301');

insert into MEMB(MNM,EMAIL,PWD,TEL) values('김평일', 'kimp@test.com', '1111', '111-1111');
insert into MEMB(MNM,EMAIL,PWD,TEL) values('배윤호', 'bae@test.com', '1111', '222-2222');
insert into MEMB(MNM,EMAIL,PWD,TEL) values('최춘호', 'choi@test.com', '1111', '333-3333');
insert into MEMB(MNM,EMAIL,PWD,TEL) values('박현신', 'park@test.com', '1111', '444-4444');
insert into MEMB(MNM,EMAIL,PWD,TEL) values('이천배', 'lee@test.com', '1111', '555-5555');

insert into CLMEM(CNO,MNO) values('1','1');
insert into CLMEM(CNO,MNO) values('1','2');
insert into CLMEM(CNO,MNO) values('1','3');
insert into CLMEM(CNO,MNO) values('1','4');
insert into CLMEM(CNO,MNO) values('1','5');

insert into PROJEC(PNM,CONT,ST_DT,ED_DT) 
values('프로젝트1','프로젝트 관리 매니저 개발','ㅁㄴㅇㄹ','2016-2-15','2016-8-4');

insert into PJMEMB(PNO,MNO) values('1', '1');
insert into PJMEMB(PNO,MNO) values('1', '2');
insert into PJMEMB(PNO,MNO) values('1', '3');
insert into PJMEMB(PNO,MNO) values('1', '4');
insert into PJMEMB(PNO,MNO) values('1', '5');

insert into POSTS(TITLE,PNO,MNO,CONT,W_DT)
values('1번글','1','1','김평일이 쓴 글',now());
insert into POSTS(TITLE,PNO,MNO,CONT,W_DT)
values('2번글','1','2','배윤호가 쓴 글',now());
insert into POSTS(TITLE,PNO,MNO,CONT,W_DT)
values('3번글','1','3','최춘호가 쓴 글',now());
insert into POSTS(TITLE,PNO,MNO,CONT,W_DT)
values('4번글','1','4','박현신이 쓴 글',now());
insert into POSTS(TITLE,PNO,MNO,CONT,W_DT)
values('5번글','1','5','이천배가 쓴 글',now());

insert into TSK(TNM,PNO,MNO,CONT,ST_DT,ED_DT)
values('작업1', '1','1','김평일의 작업','2016-01-01','2016-01-10');
insert into TSK(TNM,PNO,MNO,CONT,ST_DT,ED_DT)
values('작업2', '1','2','배윤호의 작업','2016-02-01','2016-02-10');
insert into TSK(TNM,PNO,MNO,CONT,ST_DT,ED_DT)
values('작업3', '1','3','최춘호의 작업','2016-03-01','2016-03-10');
insert into TSK(TNM,PNO,MNO,CONT,ST_DT,ED_DT)
values('작업4', '1','4','박현신의 작업','2016-04-01','2016-04-10');
insert into TSK(TNM,PNO,MNO,CONT,ST_DT,ED_DT)
values('작업5', '1','5','이천배의 작업','2016-05-01','2016-05-10');

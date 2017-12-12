-- create schema and dual first time through
create schema TEST ;
create table DUAL ( id int, val varchar(32));
insert into DUAL values(1,'one');

-- load Account table
insert into ACCOUNT(acct_number,balance,acct_type) values ('1234567890',100.0, 'Checking');
insert into ACCOUNT(acct_number,balance,acct_type) values ('2341567891',1000.0, 'Savings');
insert into ACCOUNT(acct_number,balance,acct_type) values ('3412567892',10000.0, 'Money Market');
insert into ACCOUNT(acct_number,balance,acct_type) values ('4321567893',100000.0, '401K');

select acct_number, balance, acct_type 
		from account 
		where acct_number IN ('1234567890','2341567891')
		
		:acct

select * from account
		
CREATE TABLE "TEST"."AUDIT"
(
   ID varchar(36) PRIMARY KEY NOT NULL,
   EVENT_TIME timestamp,
   ACCOUNT_NUMBER varchar(10),
   ACTION varchar(32),
   AMOUNT decimal(9)
)
;


SELECT ID,EVENT_TIME,ACCOUNT_NUMBER,ACTION,AMOUNT FROM "TEST"."AUDIT";

INSERT INTO "TEST"."AUDIT" (ID,EVENT_TIME,ACCOUNT_NUMBER,ACTION,AMOUNT) VALUES ('s' /*not nullable*/,{ts '2014-11-17 11:13:24.100000'},'s','s',0);


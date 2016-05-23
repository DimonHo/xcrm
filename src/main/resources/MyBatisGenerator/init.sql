--系统用户表
drop table x_user;
create table x_user(
id number(10) CONSTRAINT x_user_id_pk PRIMARY KEY,
name varchar2(32),
real_name varchar2(64),
account_no varchar2(64) CONSTRAINT x_user_accountNo_uk unique,
pwd varchar2(64),
email varchar2(64),
mobile_phone number(11),
addr_id number(10),
last_login timestamp
);

COMMENT ON TABLE x_user IS '用户表';
COMMENT ON COLUMN x_user.name IS '昵称';
COMMENT ON COLUMN x_user.real_name IS '真实姓名';
COMMENT ON COLUMN x_user.account_no IS '登陆账号';
COMMENT ON COLUMN x_user.pwd IS '密码';
COMMENT ON COLUMN x_user.email IS '邮箱';
COMMENT ON COLUMN x_user.mobile_phone IS '手机号码';
COMMENT ON COLUMN x_user.addr_id IS '地址ID，外键关联地址表';
COMMENT ON COLUMN x_user.last_login IS '最后登陆时间';

drop sequence xUser_seq;
CREATE SEQUENCE xUser_seq
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--这里原本是想做一个ID自增长的触发器的，但是我用pl/sql developer每次向x_user表中
--插入数据的时候就会报一个#通信信道结尾#的错误，
--找了半天没找出原因o(╯□╰)o，没办法，我的数据库太渣了，还请知道的高手不吝赐教。
CREATE OR REPLACE TRIGGER ins_xUser_triger BEFORE
INSERT ON x_user FOR EACH ROW WHEN (new.id is null)
begin
select xUser_seq.Nextval into: new.id from dual;
end;

--地址表
drop table x_addr;
create table x_addr(
id number(10) CONSTRAINT x_addr_id_pk PRIMARY KEY,
prov_addr varchar2(32),
ctiy_addr varchar2(32),
dist_addr varchar2(32),
detail_addr varchar2(100),
addr_type char
);

COMMENT ON TABLE x_addr IS '地址表';
COMMENT ON COLUMN x_addr.prov_addr IS '省';
COMMENT ON COLUMN x_addr.ctiy_addr IS '市';
COMMENT ON COLUMN x_addr.dist_addr IS '区';
COMMENT ON COLUMN x_addr.detail_addr IS '详细地址';
COMMENT ON COLUMN x_addr.addr_type IS '地址类型';

--枚举字典表
drop table x_dic;
create table x_dic(
id number(10) constraint x_dic_id_pk primary key,
rel_table varchar2(32) not null,
rel_col varchar2(32) not null,
dic_key char,
dic_value varchar2(32)
);
COMMENT ON TABLE x_dic IS '枚举字典表';
COMMENT ON COLUMN x_dic.rel_table IS '所属表';
COMMENT ON COLUMN x_dic.rel_col IS '所属字段';
COMMENT ON COLUMN x_dic.dic_key IS '字典key';
COMMENT ON COLUMN x_dic.dic_value IS '字典值';

--登陆登出记录
create table x_login(
id number(10) constraint x_login_id_pk primary key,
local_ip varchar2(32),
internet_ip varchar2(32),
login_time timestamp,
logout_time timestamp,
ip_addr varchar2(32)
);
COMMENT ON TABLE x_login IS '登陆记录';
COMMENT ON COLUMN x_login.local_ip IS '本地地址';
COMMENT ON COLUMN x_login.internet_ip IS '网络地址';
COMMENT ON COLUMN x_login.login_time IS '登陆时间';
COMMENT ON COLUMN x_login.logout_time IS '登出时间';
COMMENT ON COLUMN x_login.ip_addr IS 'IP所在地';
--系统用户表
truncate table xuser;
drop table xuser;

create table xuser(   
xuser_id number(10),
xuser_name varchar2(32),
xuser_realName varchar2(64),
xuser_acctno varchar2(64),
xuser_pwd varchar2(64),
xuser_email varchar2(64),
xuser_mphone varchar2(11),
xuser_addrId number(10),
xuser_lastLogin timestamp,
CONSTRAINT pk_xuser PRIMARY KEY (xuser_id),
CONSTRAINT uk_xuser UNIQUE (xuser_acctno)
);
--alter table xuser modify (xuser_mphone varchar2(11));
COMMENT ON TABLE xuser IS '用户表';
COMMENT ON COLUMN xuser.xuser_name IS '昵称';
COMMENT ON COLUMN xuser.xuser_realName IS '真实姓名';
COMMENT ON COLUMN xuser.xuser_acctno IS '登陆账号';
COMMENT ON COLUMN xuser.xuser_pwd IS '密码';
COMMENT ON COLUMN xuser.xuser_email IS '邮箱';
COMMENT ON COLUMN xuser.xuser_mphone IS '手机号码';
COMMENT ON COLUMN xuser.xuser_addrId IS '地址ID，外键关联地址表';
COMMENT ON COLUMN xuser.xuser_lastLogin IS '最后登陆时间';

--创建序列
drop sequence xUser_seq;
CREATE SEQUENCE xUser_seq
INCREMENT BY 1
START WITH 1
NOMAXVALUE
NOCYCLE
NOCACHE;

--ID自增长的触发器
CREATE OR REPLACE TRIGGER ins_xUser_triger
  BEFORE INSERT ON xuser
  FOR EACH ROW
  WHEN (new.xuser_id is null)
begin
  select xUser_seq.Nextval into :new.xuser_id from dual;
end;

select  xUser_seq.Currval from dual;

insert into xuser values
  (null,
   'dimonho',
   '何志刚',
   'vampirehgg',
   'abc123',
   'vampirehgg@qq.com',
   '18684848230',
   1,
   sysdate);
   
select * from xuser;
------------------------------------------------------------------------------
--地址表
drop table xaddr;
create table xaddr(
xaddr_id number(10),
xaddr_prov varchar2(32),
xaddr_ctiy varchar2(32),
xaddr_dist varchar2(32),
xaddr_detail varchar2(100),
xaddr_type char,
CONSTRAINT pk_xaddr PRIMARY KEY (xaddr_id)
);

COMMENT ON TABLE xaddr IS '地址表';
COMMENT ON COLUMN xaddr.xaddr_prov IS '省';
COMMENT ON COLUMN xaddr.xaddr_ctiy IS '市';
COMMENT ON COLUMN xaddr.xaddr_dist IS '区';
COMMENT ON COLUMN xaddr.xaddr_detail IS '详细地址';
COMMENT ON COLUMN xaddr.xaddr_type IS '地址类型';

-------------------------------------------------------------------------
--枚举字典表
drop table xdic;
create table xdic(
xdic_id number(10),
xdic_tab varchar2(32) not null,
xdic_col varchar2(32) not null,
xdic_key char(2),
xdic_val varchar2(32),
constraint pk_xdic primary key (xdic_id)
);
COMMENT ON TABLE xdic IS '枚举字典表';
COMMENT ON COLUMN xdic.xdic_id IS '所属表';
COMMENT ON COLUMN xdic.xdic_col IS '所属字段';
COMMENT ON COLUMN xdic.xdic_key IS '字典key';
COMMENT ON COLUMN xdic.xdic_val IS '字典值';

--登陆登出记录
create table xlogin(
xlogin_id number(10),
xlogin_localip varchar2(32),
xlogin_netip varchar2(32),
xlogin_logintime timestamp,
xlogin_logouttime timestamp,
xlogin_ipaddr varchar2(32),
constraint pk_xlogin primary key (xlogin_id)
);

COMMENT ON TABLE xlogin IS '登陆记录';
COMMENT ON COLUMN xlogin.xlogin_localip IS '本地地址';
COMMENT ON COLUMN xlogin.xlogin_netip IS '网络地址';
COMMENT ON COLUMN xlogin.xlogin_logintime IS '登陆时间';
COMMENT ON COLUMN xlogin.xlogin_logouttime IS '登出时间';
COMMENT ON COLUMN xlogin.xlogin_ipaddr IS 'IP所在地';

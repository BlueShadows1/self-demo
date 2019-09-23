-- noinspection SqlNoDataSourceInspectionForFile

DROP TABLE IF EXISTS user;

CREATE TABLE user
(
  id      BIGINT (20) NOT NULL COMMENT '主键ID',
  name    VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
  age     INT (11) NULL DEFAULT NULL COMMENT '年龄',
  email   VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (id)
);

drop table if exists oauth2_client;
create table oauth2_client (
  id int auto_increment primary key,
  clientId varchar(50),
  clientSecret varchar(50),
  redirectUrl varchar(2000),
  grantType varchar(100),
  scope varchar(100)
);

drop table if exists oauth2_user;
create table oauth2_user (
  id int auto_increment primary key,
  username varchar(50),
  password varchar(50)
);






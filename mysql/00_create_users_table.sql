create table users (
       id char(36) primary key,
       username varchar(32) not null unique,
       password varchar(255) not null,
       email varchar(255) not null unique,
       type int not null
);

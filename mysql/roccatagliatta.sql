create database if not exists roccatagliatta;

create user 'roccatagliatta'@'%' identified by 'secret';

grant all privileges on roccatagliatta.* to 'roccatagliatta'@'%' with grant option;

create table users (
       id binary(16) primary key,
       username varchar(32) not null unique,
       password varchar(255) not null,
       email varchar(255) not null unique,
       role_id binary(16),
       foreign key (role_id) references roles(id)
);

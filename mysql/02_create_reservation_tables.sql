create table tables (
       id int primary key,
       seats int not null
);

create table reservations (
       id char(36) primary key,
       table_id int not null,
       name varchar(255) not null,
       start_time datetime not null,
       end_time datetime not null,
       guests int not null,

       unique (id, table_id),

       foreign key (table_id) references tables(id)
);

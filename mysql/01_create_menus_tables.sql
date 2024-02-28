create table menus (
       id char(36) primary key,
       year int not null,
       month int not null,
       day int not null,

       unique (year, month, day)
);

create table menu_items (
       id char(36) primary key,
       menu_id char(36) not null,
       name varchar(50) not null,
       description varchar(255) not null,
       category int not null,
       price decimal(10, 2) not null,

       unique (menu_id, name),

       foreign key (menu_id) references menus(id)
);

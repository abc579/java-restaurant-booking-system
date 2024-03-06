insert into users (
       id,
       username,
       password,
       email,
       type
)
values (
       "ad2296ae-c0cb-412e-bb63-e2b3c1d3470c",
       "liwakura",
       "dummyPassword",
       "liwakura@wired.cz",
       0
);

insert into menus (
       id,
       year,
       month,
       day)
values (
       "e03d8309-41fd-4dfd-979d-fd5663e911bb",
       2024,
       1,
       1);

insert into menus (
       id,
       year,
       month,
       day)
values (
       "f5eeb8ee-fc60-4f11-8800-0601af11148b",
       2024,
       2,
       2);

insert into menu_items (
       id,
       menu_id,
       name,
       description,
       category,
       price)
values (
       "bcccbdd2-777b-4e44-8198-0b59f9793a82",
       "e03d8309-41fd-4dfd-979d-fd5663e911bb",
       "Dummy Food Name",
       "Dummy Food Description",
       0,
       20.55);

insert into menu_items (
       id,
       menu_id,
       name,
       description,
       category,
       price)
values (
       "3f80f369-01e6-450d-be29-e7666e1c7af7",
       "f5eeb8ee-fc60-4f11-8800-0601af11148b",
       "Dummy Food 2 Name",
       "Dummy Food 2 Description",
       1,
       69.69);

insert into tables (
       id,
       seats
)
values (
       1,
       2
);

insert into tables (
       id,
       seats
)
values (
       2,
       2
);

insert into tables (
       id,
       seats
)
values (
       3,
       2
);

insert into tables (
       id,
       seats
)
values (
       4,
       2
);

insert into tables (
       id,
       seats
)
values (
       5,
       4
);

insert into tables (
       id,
       seats
)
values (
       6,
       2
);

insert into reservations (
       id,
       table_id,
       name,
       start_time,
       end_time,
       guests
)
values (
       "ba09250b-0a79-47a9-9464-0dc9e1292ce0",
       5,
       "Guest Name For Reservation Example",
       "2099-01-01T10:30:00",
       "2099-01-01T12:30:00",
       4
);

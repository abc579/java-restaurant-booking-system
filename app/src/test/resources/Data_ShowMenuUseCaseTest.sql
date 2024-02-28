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

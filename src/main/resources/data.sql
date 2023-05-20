create table categories(
    id int primary key auto_increment,
    description varchar(100) not null
);

insert into categories (description) values ('Medicines');
insert into categories (description) values ('Generic');
insert into categories (description) values ('Similar');
insert into categories (description) values ('Radiative');
insert into categories (description) values ('UnderGeneric');
create database employees;

use employees;

create table employees
(
  username varchar(15) not null primary key,
  password varchar(15) not null,
  roleid integer not null,
  name varchar(30) not null,
  phone varchar(15) not null,
  email varchar(30) not null,
  depid integer not null
);

insert into employees values("abrickey", "$word", 1, "Art Brickey", "(303) 555-1214", "abrickey@where.com", 2);
insert into employees values("tharris", "ralph", 1, "Todd Harris", "(303) 555-9482", "tharris@where.com", 2);
insert into employees values("sriley", "$mindy$", 2, "Sean Riley", "(303) 555-3412", "sriley@where.com", 4);
insert into employees values("jgoodwill", "$pass$", 1, "James Goodwill", "(303) 555-1214", "jgoodwill@where.com", 3);
insert into employees values("tgray", "password", 2, "Tim Gray", "(303) 555-9876", "tgray@where.com", 1);

create table roles
(
  roleid integer not null primary key,
  rolename varchar(30) not null
);

insert into roles values(1, "manager");
insert into roles values(2, "employee");


create table departments
(
  depid integer not null primary key,
  depname varchar(30) not null
);

insert into departments values(1, "Administration");
insert into departments values(2, "Network");
insert into departments values(3, "Sales");
insert into departments values(4, "Engineering");

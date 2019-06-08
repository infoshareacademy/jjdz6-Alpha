show databases ;

show tables ;

create table test (
  id INT,
  value VARCHAR(255)
);

-- vehicles

create table vehicles(
  id INT PRIMARY KEY auto_increment,
  name TEXT not null ,
  tank_size INT,
  capacity INT not null
);

create table drivers(
                       id INT PRIMARY KEY auto_increment,
                       name varchar(255) not null ,
                       salary INT not null
);

alter table drivers add vehicle_id int;
alter table drivers add constraint fk_vehicle_id foreign key (vehicle_id) references vehicles(id);



create table routes(
                       id INT PRIMARY KEY auto_increment,
                       start varchar(255) not null ,
                       destination varchar(255) not null ,
                       date DATETIME
);

alter table routes add driver_id int;
alter table routes add constraint fk_driver_id foreign key (driver_id) references drivers(id);


create table licences(
                      id INT PRIMARY KEY auto_increment,
                      code varchar(255) not null ,
                      description varchar(255) not null
);

create table drivers_licences (
  id int primary key auto_increment,
  driver_id int ,
  licence_id int,
  foreign key fk_driver_id(driver_id) references drivers(id),
  foreign key fk_licence_id(licence_id) references licences(id)
);


alter table routes modify destination not null ;

alter table drivers add fk_vehicle_id int;
alter table drivers add constraint fk_vehicle_id foreign key (vehicle_id) references vehicles(id);
-- alter table drivers add foreign key



describe routes;
-- przyklady insero
insert into vehicles (name, tank_size, capacity)
values ("VW-Passat","100","3");

insert into vehicles
values (2,"BMW-X5","100","3");


insert into vehicles (name, capacity)
values ("Mercedes-W-125","2");



select * from vehicles;

select * from vehicles where capacity > 2;


select * from vehicles where name like "%BMW%";

select * from vehicles where tank_size is NOT null;

-- ----------------------------------------
select * from vehicles where tank_size is not null;
select * from vehicles where name LIKE "%VW%" and capacity > 1;
select * from vehicles where capacity between 1 and 10;

-- -------------------------------------
-- funkcje agregujace count min max avg

select count( distinct  name) from vehicles;
select count(name) from vehicles;


-- -----------------------------------------------

select avg(name) as average_name from vehicles;

-- group by

select v.name, count(*) from vehicles as v group by name;


-- ile pojazdow ma taka sama ladownosc

select v.capacity, count(v.capacity) as number_of_vehicles from vehicles as v group by v.capacity;

select v.capacity, count(*) as number_of_vehicles from vehicles as v group by v.capacity;


describe vehicles;

show columns from test;

describe test;
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

alter table routes add vehicle_id int;
alter table routes add constraint fk_vehicle_id_routes foreign key (vehicle_id) references vehicles(id);

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

-- dane do drivers

select * from drivers;
insert into drivers (name, salary, vehicle_id) values ("Andrzej", 2500, 1);
insert into drivers (name, salary, vehicle_id) values ("Olek", 3500, 2);
insert into drivers (name, salary, vehicle_id) values ("Janusz", 4500, 3);

-- add licences
select * from licences;
insert into licences (code, description) VALUES ("B", "osobowe");
insert into licences (code, description) VALUES ("C", "ciezarowe");
insert into licences (code, description) VALUES ("C+E", "ciezarowe+przyczepa");

-- add drivers_licences
select * from drivers_licences;
insert into drivers_licences (driver_id, licence_id) VALUES (1,1);
insert into drivers_licences (driver_id, licence_id) VALUES (1,2);
insert into drivers_licences (driver_id, licence_id) VALUES (1,3);
insert into drivers_licences (driver_id, licence_id) VALUES (2,2);
insert into drivers_licences (driver_id, licence_id) VALUES (2,3);
insert into drivers_licences (driver_id, licence_id) VALUES (3,3);

-- add routes

select * from routes;

insert into routes (start, destination, date, driver_id, vehicle_id)
VALUES ("Gdańsk", "Gdynia", '2019-05-01', 1,1);

insert into routes (start, destination, date, driver_id, vehicle_id)
VALUES ("Gdańsk", "Gdynia", '2019-05-02', 2,2);

insert into routes (start, destination, date, driver_id, vehicle_id)
VALUES ("Gdańsk", "Gdynia", '2019-05-03', 3,3);


-- modyfakacja rekordow

update drivers set name="Janusz-K" where id = 3;
select * from  drivers;

-- usun nieuzywane pojazdy
select * from vehicles;
insert into vehicles(name, tank_size, capacity) VALUES ("Opel", 100, 2);

-- nieuzywane pojazdy 0
select * from vehicles as v
  left join drivers as d on d.vehicle_id = v.id
where d.vehicle_id is null;



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
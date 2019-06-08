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
select * from driver_licenses;
insert into driver_licenses (driver_id, licence_id) VALUES (1,1);
insert into driver_licenses (driver_id, licence_id) VALUES (1,2);
insert into driver_licenses (driver_id, licence_id) VALUES (1,3);
insert into driver_licenses (driver_id, licence_id) VALUES (2,2);
insert into driver_licenses (driver_id, licence_id) VALUES (2,3);
insert into driver_licenses (driver_id, licence_id) VALUES (3,3);

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

-- uzywane pojazdy i licencje
select d.name, v.name, dl.licence_id from vehicles as v
join drivers as d on d.vehicle_id = v.id
join driver_licenses as dl on dl.driver_id = d.id;

-- czyszczenie danych
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE drivers;
TRUNCATE routes;
TRUNCATE driver_licenses;
TRUNCATE licences;
TRUNCATE vehicles;

SET FOREIGN_KEY_CHECKS = 1;

ALTER table drivers auto_increment = 1;
ALTER table routes auto_increment = 1;
ALTER table driver_licenses auto_increment = 1;
ALTER table licences auto_increment = 1;
ALTER table vehicles auto_increment = 1;


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

select * from vehicles;

insert into vehicles (name, tank_size, capacity)
values ("Scania 100900", 100, 40000);
insert into vehicles (name, tank_size, capacity)
values ("Scania 1500", 100, 45000);
insert into vehicles (name, tank_size, capacity)
values ("Volvo V190", 80, 42000);
insert into vehicles (name, tank_size, capacity)
values ("Star A1", 120, 20000);
insert into vehicles (name, capacity)
values ("Mercedes W11", 52000);
insert into vehicles (name, tank_size, capacity)
values ("Scania B52", 90, 39000);
insert into vehicles (name, capacity)
values ("Mercedes KEK", 9500);

select * from drivers;

insert into drivers (name, salary, vehicle_id)
VALUES ("Tytus", 3700, 1);
insert into drivers (name, salary, vehicle_id)
VALUES ("Sebastian", 3200, 2);
insert into drivers (name, salary, vehicle_id)
VALUES ("Dominik", 2600, 2);
insert into drivers (name, salary, vehicle_id)
VALUES ("Janusz", 3350, 3);
insert into drivers (name, salary, vehicle_id)
VALUES ("Julia", 2700, 3);
insert into drivers (name, salary, vehicle_id)
VALUES ("Luigi", 3490, 3);
insert into drivers (name, salary, vehicle_id)
VALUES ("Andrzej", 3030, 4);
insert into drivers (name, salary, vehicle_id)
VALUES ("Remik", 3200, 5);
insert into drivers (name, salary, vehicle_id)
VALUES ("Kamil", 3200, 5);
insert into drivers (name, salary, vehicle_id)
VALUES ("Klaudia", 3100, 6);
insert into drivers (name, salary)
VALUES ("Alojzy", 2300);
insert into drivers (name, salary)
VALUES ("Andżelika", 2300);

select * from routes;

insert into routes (start, destination, date)
values ("Gdańsk", "Warszawa", current_date);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Warszawa", "Kraków", date("2019-06-08"), 6, 10);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Gdańsk", "Kraków", date("2019-06-08"), 5, 8);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Sztum", "Gdańsk", date("2019-06-08"), 4, 7);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Kraków", "Mińsk", date("2019-06-08"), 3, 4);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Gdańsk", "Buenos Aires", date("2019-06-08"), 2, 2);
insert into routes(start, destination, date, vehicle_id)
values ("Toruń", "Gdańsk", date("2017-06-08"), 1);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Toruń", "Poznań", date("2019-06-08"), 1, 1);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Poznań", "Gdańsk", date("2019-06-08"), 2, 3);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Gdańsk", "Toruń", date("2019-06-08"), 3, 5);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Warszawa", "Białystok", date("2019-06-08"), 4, 7);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Gdańsk", "Kraków", date("2019-06-08"), 7, 4);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Poznań", "Warszawa", date("2019-06-08"), 7, 11);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Gdańsk", "Sztum", date("2019-06-08"), 7, 12);
insert into routes(start, destination, date, vehicle_id, driver_id)
values ("Warszawa", "Kraków", date("2019-06-08"), 5, 9);

insert into licences (code, description)
values (11, "C+E");
insert into licences (code, description)
values (15, "super licencja");
insert into licences (code, description)
values (2, "C");
insert into licences (code, description)
values (4, "D");

select * from driver_licenses;

insert into driver_licenses (driver_id, licence_id)
values (1, 2);
insert into driver_licenses (driver_id, licence_id)
values (2, 1);
insert into driver_licenses (driver_id, licence_id)
values (3, 1);
insert into driver_licenses (driver_id, licence_id)
values (4, 1);
insert into driver_licenses (driver_id, licence_id)
values (5, 2);
insert into driver_licenses (driver_id, licence_id)
values (6, 3);
insert into driver_licenses (driver_id, licence_id)
values (7, 1);
insert into driver_licenses (driver_id, licence_id)
values (8, 1);
insert into driver_licenses (driver_id, licence_id)
values (9, 1);
insert into driver_licenses (driver_id, licence_id)
values (10, 3);
insert into driver_licenses (driver_id, licence_id)
values (11, 4);



-- zad 15 lista pracownikow

select d.name, d.salary, l.description as license_name from drivers as d
join driver_licenses dl on d.id = dl.driver_id
join licences l on dl.licence_id = l.id
order by  d.salary DESC ;


-- zad 16 lista samochodow i przejechanych tras
select v.name, count(r.vehicle_id) as liczba_przejechanych_tras from routes as r
join vehicles as v on v.id = r.vehicle_id
group by r.vehicle_id
order by liczba_przejechanych_tras DESC;

select * from routes;

-- zad 17
alter table routes add liczba_kilometrow int;
describe routes;
select * from routes;

update routes set liczba_kilometrow = 10 where id = 1;
update routes set liczba_kilometrow = 100 where id = 2;
update routes set liczba_kilometrow = 20 where id = 3;
update routes set liczba_kilometrow = 330 where id = 4;

-- ile km przejechal kazdy kierowca

select d.name, sum(r.liczba_kilometrow) as liczba_kilometrow_dla_drivera from routes as r
join drivers as d on d.id = r.driver_id
group by d.name;


-- ile km przejechal kazdy pojazd

select v.name, sum(r.liczba_kilometrow) as liczba_km_dla_pojazdu from  routes as r
join vehicles as v on v.id = r.vehicle_id
group by v.name;


-- zad 18
alter table vehicles add w_warsztacie int;
describe vehicles;
select * from vehicles;

update vehicles set w_warsztacie = 1 where id = 1;
update vehicles set w_warsztacie = 1 where id = 4;
update vehicles set w_warsztacie = 1 where id = 7;

-- kierowcy ktorych wszystkie pojazdy sa w naprawie

select d.name from drivers as d
join vehicles as v on v.id = d.vehicle_id
where v.w_warsztacie is not null;

-- zad 19
alter table drivers add start_date date;
describe drivers;

update drivers set start_date = '2018-01-01' where id = 1;
update drivers set start_date = '2018-01-01' where id = 2;

select * from drivers;



select floor(datediff(now(), d.start_date)/365) as age from drivers as d;
select d.id from drivers as d where floor(datediff(now(), d.start_date)/365);


update
  drivers
  set salary = ((select salary from drivers) + 100)
where id IN (
  select d.id from drivers as d where floor(datediff(now(), d.start_date)/365)
  );





SET NAMES utf8;
-- initialize wwr db schema , init sample data

-- entity tables

-- ---------------------------------------------------------------------------------------------------------------------
create table pesel_numbers(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  number VARCHAR (255) NOT NULL
);
-- patients pesels
insert into pesel_numbers (number) values ("90101212345"); -- id =1
insert into pesel_numbers (number) values ("91101212334"); -- id =2
insert into pesel_numbers (number) values ("91101212323"); -- id =3
insert into pesel_numbers (number) values ("92101212312"); -- id =4
insert into pesel_numbers (number) values ("92101212301"); -- id =5
-- parents pesels
insert into pesel_numbers (number) values ("77101212301"); -- id =6
insert into pesel_numbers (number) values ("78101212301"); -- id =7
insert into pesel_numbers (number) values ("80101212301"); -- id =8
insert into pesel_numbers (number) values ("84101212301"); -- id =9
insert into pesel_numbers (number) values ("85101212301"); -- id =10

-- ---------------------------------------------------------------------------------------------------------------------
create table addresses (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    postalCode INT NOT NULL
);
-- patients addresses
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk", "Pilotów 23", "556 454 234", 80460); -- 1
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk", "Miałki Szlak 12", "556 111 222", 81560); -- 2
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk", "Warneńska 80", "756 121 232", 80210); -- 3
insert into addresses (city, street, phone, postalCode) VALUES ("Sopot", "Warneńska 80", "856 422 226", 80210); -- 4
insert into addresses (city, street, phone, postalCode) VALUES ("Gdynia", "Polska 11", "556 343 442", 80210); -- 5

-- facilities addresses
insert into addresses (city, street, phone, postalCode) VALUES ("Gdynia", "Augustyna Necla 11-13", "+48 58 621 74 40", 81377); -- 6
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk", "Kartuska 214", "+48 564 123 555", 80122); -- 7
insert into addresses (city, street, phone, postalCode) VALUES ("Sopot", "Zwyciestwa 17", "+48 754 123 123", 81704); -- 8
insert into addresses (city, street, phone, postalCode) VALUES ("Gdynia", "Kolejowa 23", "+48 112 123 123", 81303); -- 9
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk", "Jagiellońska 11", "+48 508 186 021", 81368); -- 10
insert into addresses (city, street, phone, postalCode) VALUES ("Gdańsk-Oliwa", "Matemblewska 42", "+48 602 491 421", 80830); -- 11
insert into addresses (city, street, phone, postalCode) VALUES ("Gdynia", "Harcerska 4", "+48 58 622 07 48", 81425); -- 12
insert into addresses (city, street, phone, postalCode) VALUES ("Gdynia", "Portowa 1", "+48 112 234 123", 81339); -- 13
-- ---------------------------------------------------------------------------------------------------------------------

CREATE TABLE parents (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    pesel_id INT NOT NULL,
    CONSTRAINT fk_parents_pesel_id FOREIGN KEY (pesel_id) REFERENCES pesel_numbers(id)
);

insert into parents (name, surname, pesel_id) VALUES ("Michał", "Łukaszewski", 6); -- id =1
insert into parents (name, surname, pesel_id) VALUES ("Jan", "Jakowski", 7);       -- id =2
insert into parents (name, surname, pesel_id) VALUES ("Karolina", "Kowalska", 8);  -- id =3
insert into parents (name, surname, pesel_id) VALUES ("Dorota", "Dorocińska", 9);  -- id =4
insert into parents (name, surname, pesel_id) VALUES ("Kamila", "Kot", 10);        -- id =5

-- ---------------------------------------------------------------------------------------------------------------------
CREATE TABLE patients (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    pesel_id INT NOT NULL,
    parent_id INT NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT fk_patients_pesel_id FOREIGN KEY (pesel_id) REFERENCES pesel_numbers(id),
    CONSTRAINT fk_patients_parent_id FOREIGN KEY (parent_id) REFERENCES parents(id),
    CONSTRAINT fk_patients_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
);

insert into patients (name, surname, pesel_id, parent_id, address_id) VALUES ("Łukasz", "Łukaszewski", 1, 1, 1); -- id =1
insert into patients (name, surname, pesel_id, parent_id, address_id) VALUES ("Magda", "Jakowska", 2, 2, 2); -- id =2
insert into patients (name, surname, pesel_id, parent_id, address_id) VALUES ("Adam", "Kowalski", 3, 3, 3); -- id =3
insert into patients (name, surname, pesel_id, parent_id, address_id) VALUES ("Kornelia", "Dorocińska", 4, 4, 4); -- id =4
insert into patients (name, surname, pesel_id, parent_id, address_id) VALUES ("Mieszko", "Kot", 5, 5, 5);  -- id =5

-- ---------------------------------------------------------------------------------------------------------------------

create table facilities (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  is_nfz BOOLEAN NOT NULL,
  address_id INT NOT NULL,
  CONSTRAINT fk_facilities_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
);

insert into facilities (name, is_nfz, address_id) values ("Ośrodek Wczesnej Interwencji - filia nr 1 Niepubliczny Zakład Opieki Zdrowotnej",true,6);
insert into facilities (name, is_nfz, address_id) values ("Wyspa",false,7);
insert into facilities (name, is_nfz, address_id) values ("Poradnia psychologiczno-pedagogiczna, filia nr 6",true,8);
insert into facilities (name, is_nfz, address_id) values ("Poradnia psychologiczno-pedagogiczna, filia nr 7",true,9);
insert into facilities (name, is_nfz, address_id) values ("Ośrodek Wczesnej Interwencji i Wspomagania Rozwoju",false,10);
insert into facilities (name, is_nfz, address_id) values ("ODiTiS",true,11);
insert into facilities (name, is_nfz, address_id) values ("Centrum Rehabilitacji Ośrodek Wczesnej Interwencji w Gdyni",true,12);
insert into facilities (name, is_nfz, address_id) values ("Poradnia psychologiczno-pedagogiczna, filia nr 4",true,13);

-- ---------------------------------------------------------------------------------------------------------------------
create table services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

insert into services (name) values("Metoda Ruchu Rozwijającego W.Sherborne."); -- 1
insert into services (name) values("Metoda Dobrego Startu (MDS) M.Bogdanowicz."); -- 2
insert into services (name) values("Dziecięca matematyka E.Gruszczyk- Kolczyńskiej."); -- 3
insert into services (name) values("Metoda pedagogiki zabawy."); -- 4
insert into services (name) values("Elementy Metody M.Montessori."); -- 5
insert into services (name) values("Metoda kinezjologii edukacyjnej Paula Dennisona."); -- 6
insert into services (name) values("Elementy Metody zabawy niedyrektywnej V. Axline."); -- 7
insert into services (name) values("Elementy Metody M.Frostig i D.Horne. "); -- 8
insert into services (name) values("Gry i zabawy ogólnorozwojowe."); -- 9
insert into services (name) values("Zajęcia w Sali Doświadczania Świata."); -- 10
insert into services (name) values("Zabawy materiałami nieustrukturowanymi."); -- 11
insert into services (name) values("Mandala."); -- 12
insert into services (name) values("rehabilitacja"); -- 13
insert into services (name) values("terapia SI"); -- 14
insert into services (name) values("pedagog specjalny"); -- 15
insert into services (name) values("psycholog specialny"); -- 16
insert into services (name) values("neurologopeda"); -- 17
insert into services (name) values("neurolog"); -- 18


-- relational tables
-- create table facilities_addresses (
--    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--    facility_id INT NOT NULL,
--    address_id INT NOT NULL,
--    CONSTRAINT fk_facilities_addresses_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
--    CONSTRAINT fk_facilities_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
-- );

-- to delete
-- create table patients_addresses (
--    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
--    patient_id INT NOT NULL,
--    address_id INT NOT NULL,
--    CONSTRAINT fk_patients_addresses_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
--    CONSTRAINT fk_patients_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
-- );
-- ---------------------------------------------------------------------------------------------------------------------
 create table facilities_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    facility_id INT NOT NULL,
    service_id INT NOT NULL,
    CONSTRAINT fk_facilities_services_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
    CONSTRAINT fk_facilities_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
 );

 insert into facilities_services (facility_id, service_id) values(1,13);
 insert into facilities_services (facility_id, service_id) values(1,14);
 insert into facilities_services (facility_id, service_id) values(1,15);
 insert into facilities_services (facility_id, service_id) values(1,16);
 insert into facilities_services (facility_id, service_id) values(1,17);

 insert into facilities_services (facility_id, service_id) values(2,13);
 insert into facilities_services (facility_id, service_id) values(2,17);

 insert into facilities_services (facility_id, service_id) values(3,15);
 insert into facilities_services (facility_id, service_id) values(3,18);

 insert into facilities_services (facility_id, service_id) values(4,13);
 insert into facilities_services (facility_id, service_id) values(4,17);

 insert into facilities_services (facility_id, service_id) values(5,15);
 insert into facilities_services (facility_id, service_id) values(5,16);

 insert into facilities_services (facility_id, service_id) values(6,14);
 insert into facilities_services (facility_id, service_id) values(6,15);

 insert into facilities_services (facility_id, service_id) values(7,13);
 insert into facilities_services (facility_id, service_id) values(7,14);
 insert into facilities_services (facility_id, service_id) values(7,15);
 insert into facilities_services (facility_id, service_id) values(7,16);
 insert into facilities_services (facility_id, service_id) values(7,17);

 insert into facilities_services (facility_id, service_id) values(8,14);
 insert into facilities_services (facility_id, service_id) values(8,15);

-- ---------------------------------------------------------------------------------------------------------------------
 create table patients_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    service_id INT NOT NULL,
    CONSTRAINT fk_patients_services_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
 );

 insert into patients_services (patient_id, service_id) values (1,16);
 insert into patients_services (patient_id, service_id) values (1,17);
 insert into patients_services (patient_id, service_id) values (1,18);
 insert into patients_services (patient_id, service_id) values (2,13);
 insert into patients_services (patient_id, service_id) values (2,14);
 insert into patients_services (patient_id, service_id) values (3,12);
 insert into patients_services (patient_id, service_id) values (4,15);
 insert into patients_services (patient_id, service_id) values (5,16);

-- ---------------------------------------------------------------------------------------------------------------------
 create table patients_facilities (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    facility_id INT NOT NULL,
    CONSTRAINT fk_patients_facilities_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_facilities_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id)
 );
-- facilities 1-8
-- patient 1-5
 insert into patients_facilities (patient_id, facility_id) values (1,1);
 insert into patients_facilities (patient_id, facility_id) values (1,2);
 insert into patients_facilities (patient_id, facility_id) values (1,3);

 insert into patients_facilities (patient_id, facility_id) values (2,2);
 insert into patients_facilities (patient_id, facility_id) values (2,5);
 insert into patients_facilities (patient_id, facility_id) values (2,7);
 insert into patients_facilities (patient_id, facility_id) values (2,8);

 insert into patients_facilities (patient_id, facility_id) values (3,8);
 insert into patients_facilities (patient_id, facility_id) values (3,7);
 insert into patients_facilities (patient_id, facility_id) values (3,1);

 insert into patients_facilities (patient_id, facility_id) values (4,2);
 insert into patients_facilities (patient_id, facility_id) values (4,8);
 insert into patients_facilities (patient_id, facility_id) values (4,3);

 insert into patients_facilities (patient_id, facility_id) values (5,5);
 insert into patients_facilities (patient_id, facility_id) values (5,4);
 insert into patients_facilities (patient_id, facility_id) values (5,1);

-- ---------------------------------------------------------------------------------------------------------------------




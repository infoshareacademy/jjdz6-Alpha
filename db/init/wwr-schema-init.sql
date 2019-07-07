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
    CONSTRAINT fk_patients_pesel_id FOREIGN KEY (pesel_id) REFERENCES pesel_numbers(id),
    CONSTRAINT fk_patients_parent_id FOREIGN KEY (parent_id) REFERENCES parents(id)
);

insert into patients (name, surname, pesel_id, parent_id) VALUES ("Łukasz", "Łukaszewski", 1, 1); -- id =1
insert into patients (name, surname, pesel_id, parent_id) VALUES ("Magda", "Jakowska", 2, 2); -- id =2
insert into patients (name, surname, pesel_id, parent_id) VALUES ("Adam", "Kowalski", 3, 3); -- id =3
insert into patients (name, surname, pesel_id, parent_id) VALUES ("Kornelia", "Dorocińska", 4, 4); -- id =4
insert into patients (name, surname, pesel_id, parent_id) VALUES ("Mieszko", "Kot", 5, 5); -- id =5

-- ---------------------------------------------------------------------------------------------------------------------

create table facilities (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  is_nfz BOOLEAN NOT NULL
);

create table services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

create table addresses (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    city VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    postalCode VARCHAR(255) NOT NULL
);

-- relational tables
 create table facilities_addresses (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    facility_id INT NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT fk_facilities_addresses_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
    CONSTRAINT fk_facilities_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
 );

 create table patients_addresses (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    address_id INT NOT NULL,
    CONSTRAINT fk_patients_addresses_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
 );

 create table facilities_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    facility_id INT NOT NULL,
    service_id INT NOT NULL,
    CONSTRAINT fk_facilities_services_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
    CONSTRAINT fk_facilities_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
 );

 create table patients_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    service_id INT NOT NULL,
    CONSTRAINT fk_patients_services_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
 );




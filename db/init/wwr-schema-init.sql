-- initialize wwr db schema , init sample data

-- entity tables
create table facilities (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  is_nfz BOOLEAN NOT NULL
);

create table patients (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
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
    PRIMARY KEY (id),
    CONSTRAINT fk_facilities_addresses_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
    CONSTRAINT fk_facilities_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
);

create table patients_addresses (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    address_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_patients_addresses_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_addresses_address_id FOREIGN KEY (address_id) REFERENCES addresses(id)
);

create table facilities_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    facility_id INT NOT NULL,
    service_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_facilities_services_facility_id FOREIGN KEY (facility_id) REFERENCES facilities(id),
    CONSTRAINT fk_facilities_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
);

create table patients_services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    patient_id INT NOT NULL,
    service_id INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_patients_services_patient_id FOREIGN KEY (patient_id) REFERENCES patients(id),
    CONSTRAINT fk_patients_services_service_id FOREIGN KEY (service_id) REFERENCES services(id)
);




-- initialize wwr db schema , init sample data

create table facilities (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  is_nfz BOOLEAN NOT NULL
);

create table services (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,

);
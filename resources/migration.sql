create database if NOT EXISTS adlister_db;

use adlister_db;

create table if not EXISTS ads(
  id int unsigned not null AUTO_INCREMENT,
  title VARCHAR(400) not null,
  description TEXT ,
  PRIMARY KEY (id)
);
drop database if exists TrainScheduleDB;

create database if not exists TrainScheduleDB;

USE TrainScheduleDB;

create table user_role(
    user_role varchar(64) primary key not null unique
);

create table user(
                     id int auto_increment primary key,
                     user_name varchar(256) not null unique,
                     user_password varchar(1024) not null,
                     user_role varchar(64) not null,
                     user_email varchar(128) not null unique,
                     foreign key(user_role) references user_role(user_role)
);


create table train(
                     id int auto_increment primary key,
                     train_name varchar(256) not null unique,

);

create table station(
                    id int auto_increment primary key,
                    station_name varchar(256) not null unique,
                    'trains' JSON,
);



insert into user_role(user_role) values
    ('USER'),('ADMIN');

insert into user(user_name,user_password,user_role,user_email) values
    ('Admin','1234','ADMIN','admin@gmail.com');
    ('User1','1111','USER','user1@gmail.com');
    ('User2','2222','USER','user2@gmail.com');
    ('User3','3333','USER','user3@gmail.com');



insert into station(station_name, trains) values
    ('Kyiv', '');


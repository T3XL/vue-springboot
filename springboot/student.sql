create database if not exists `student`
    character set utf8mb4
    collate utf8mb4_unicode_ci;
use `student`;
drop table if exists `admin`;
create table if not exists `admin` (
    id int(10) unsigned not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    name varchar(255) not null,
    primary key (id)
    );
insert into `admin` (`id`, `username`, `password`, `name`) values
    (1, 'admin', 'admin', 'Admin');
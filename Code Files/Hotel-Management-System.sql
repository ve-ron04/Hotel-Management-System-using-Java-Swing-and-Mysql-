create database hotelManagementSystem;
show databases;
use hotelManagementSystem;

create table login(username varchar(25), password varchar(25));

insert into login values('admin', '12345');

select* from login;

create table employee(name varchar(25), age varchar(10), gender varchar(15), job varchar(30),salary varchar(15), phone varchar(15), email varchar(40), aadhar varchar(20));

describe employee;
select*from employee;

create table room(roomnumber varchar(10), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));
select *from room;

create table driver(name varchar(20), age varchar(10), gender varchar(15), company varchar(20), brand varchar(20),avilable varchar(20), location varchar(40));


create table customer(name varchar(30),document varchar(20), number varchar(30), gender varchar(15), country varchar(20), roomnumber varchar(20),checkInTime varchar(100), Deposit varchar(40));
select *from customer;



create table department(department varchar(30), budget varchar(30));

insert into department values('Front Office','500000');
insert into department values('House Keeping','40000');
insert into department values('Food and Bevarages','23000');
insert into department values('Kitchen','540000');
insert into department values('Security','320000');

select *from department;

select *from employee;


-- Используя Workbench в базе данных “MyFunkDB” создайте 3 таблицы:
-- В 1-й таблице содержатся имена и номера телефонов сотрудников компании. 
-- Во 2-й таблице содержатся ведомости о зарплате и должностях сотрудников: главный директор, менеджер, рабочий. 
-- В 3-й таблице содержится информация о семейном положении, дате рождения, и месте проживания. 

use MyJoinsDB;

create table employees
(
	id_number smallint auto_increment PRIMARY KEY,
	full_name varchar(20) Not Null,
    telephone varchar(15) Not Null
);

insert into employees(id_number, full_name, telephone)
values (1, 'Демьяненко А.С.', '050-608-45-17'),
	   (2, 'Скорик В.Н.', '066-345-12-15'),
	   (3, 'Антонов М.И.', '099-654-45-99');

select * from employees;

------------------------------
create table proprietary_data
(
	id_number smallint auto_increment PRIMARY KEY,
	position varchar(20) Not Null,
    salary mediumint Not Null
);

alter table proprietary_data
add constraint FK_proprietaryEmployee
foreign key(id_number) references employees(id_number);

insert into proprietary_data(id_number, position, salary)
values (1, 'директор', 35000),
	   (2, 'менеджер', 22500),
	   (3, 'рабочий', 20000);	

select * from proprietary_data;
----------------------------
create table personal_data
(
	id_number smallint auto_increment PRIMARY KEY,
	family_status varchar(10) Not Null,
    birthday date Not Null,
    address varchar(50) Not Null
);

alter table personal_data
add constraint FK_personalEmployee
foreign key(id_number) references employees(id_number);

insert into personal_data(id_number, family_status, birthday, address)
values  (1, 'женат', '1980-12-02', 'Днепр, пр.Науки,43'),
		(2, 'женат', '1993-06-28', 'Днепр, ул.Киевская,71'),
		(3, 'холост', '2002-02-17', 'Днепр, пр.Шевченко,125');

select * from personal_data;


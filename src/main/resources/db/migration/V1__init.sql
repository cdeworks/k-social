CREATE TABLE PERSON (
	id bigint(20) primary key auto_increment,
	first_name varchar(255) not null,
	last_name varchar(255) not null
);

insert into PERSON (first_name, last_name) values ('Dave', 'Syer');
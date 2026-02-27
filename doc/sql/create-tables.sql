create table users (
	id int auto_increment primary key,
	username varchar(100) not null,
    password varchar(50) not null,
    rol int not null
);

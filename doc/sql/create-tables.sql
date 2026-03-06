create table users (
	id int not null auto_increment,
	username varchar(100) DEFAULT '',
    password varchar(100) DEFAULT '',
    rol int DEFAULT 0,
    primary key (id)
);

create table teams (
    id int auto_increment primary key,
    name varchar(100) not null,
    sede varchar(150) not null,
    image longtext
);

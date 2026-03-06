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

create table partidos (
  id int not null auto_increment,
  jornada int DEFAULT 0,
  idEquipo1 int DEFAULT 0,
  idEquipo2 int DEFAULT 0,
  puntuacionEquipo1 int DEFAULT 0,
  puntuacionEquipo2 int DEFAULT 0,
  ganador int DEFAULT 0,
  PRIMARY KEY (id),
 FOREIGN KEY (idEquipo1) REFERENCES teams(id),
 FOREIGN KEY (idEquipo2) REFERENCES teams(id)
);

-- INSERTS TABLA USUARIOS
insert into users (username, password, rol) values ("admin", "admin",1);
insert into users (username, password, rol) values ("user", "1234",2);

-- INSERTS TABLA EQUIPOS
insert into teams (name, sede) values ("Real Madrid", "Bernabeu");
insert into teams (name, sede) values ("FC Barcelona", "Camp nou");

-- INSERTS TABLA PARTIDOS
insert into partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) values (1, 1, 2, 3, 1, 1);
insert into partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) values (1, 2, 1, 4, 2, 2);
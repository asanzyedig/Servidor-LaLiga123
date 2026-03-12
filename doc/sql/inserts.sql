-- INSERTS TABLA USUARIOS
insert into users (username, password, rol) values ("admin", "admin",1);
insert into users (username, password, rol) values ("user", "1234",2);

-- Insertar equipos (ids fijos para facilitar referencias)
INSERT INTO teams (id, name, sede, puntuacionTotal, image) VALUES
(1, 'Real Madrid', 'Bernabéu', 0, NULL),
(2, 'FC Barcelona', 'Camp Nou', 0, NULL),
(3, 'Atlético de Madrid', 'Wanda Metropolitano', 0, NULL),
(4, 'Sevilla FC', 'Ramón Sánchez Pizjuán', 0, NULL),
(5, 'Valencia CF', 'Mestalla', 0, NULL),
(6, 'Villarreal CF', 'El Madrigal', 0, NULL),
(7, 'Real Betis', 'Benito Villamarín', 0, NULL),
(8, 'Athletic Club', 'San Mamés', 0, NULL);

-- Insertar partidos de ejemplo (8 jornadas × 4 partidos = 32 partidos)

-- JORNADA 1
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(1, 1, 2, 3, 1, 1),   -- Real Madrid 3 - 1 Barça
(1, 3, 4, 2, 2, 0),   -- Atlético 2 - 2 Sevilla
(1, 5, 6, 1, 2, 6),   -- Valencia 1 - 2 Villarreal
(1, 7, 8, 0, 0, 0);   -- Betis 0 - 0 Athletic

-- JORNADA 2
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(2, 1, 3, 2, 1, 1),   -- Real Madrid 2 - 1 Atlético
(2, 2, 4, 1, 3, 4),   -- Barça 1 - 3 Sevilla
(2, 5, 7, 0, 2, 7),   -- Valencia 0 - 2 Betis
(2, 6, 8, 2, 2, 0);   -- Villarreal 2 - 2 Athletic

-- JORNADA 3
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(3, 1, 4, 4, 0, 1),   -- Real Madrid 4 - 0 Sevilla
(3, 2, 5, 3, 1, 2),   -- Barça 3 - 1 Valencia
(3, 3, 6, 1, 1, 0),   -- Atlético 1 - 1 Villarreal
(3, 7, 8, 2, 1, 7);   -- Betis 2 - 1 Athletic

-- JORNADA 4
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(4, 1, 5, 3, 2, 1),   -- Real Madrid 3 - 2 Valencia
(4, 2, 3, 2, 2, 0),   -- Barça 2 - 2 Atlético
(4, 4, 6, 1, 0, 4),   -- Sevilla 1 - 0 Villarreal
(4, 7, 1, 0, 2, 1);   -- Betis 0 - 2 Real Madrid

-- JORNADA 5
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(5, 1, 6, 2, 1, 1),   -- Real Madrid 2 - 1 Villarreal
(5, 2, 7, 1, 0, 2),   -- Barça 1 - 0 Betis
(5, 3, 5, 3, 1, 3),   -- Atlético 3 - 1 Valencia
(5, 4, 8, 2, 2, 0);   -- Sevilla 2 - 2 Athletic

-- JORNADA 6
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(6, 1, 8, 2, 0, 1),   -- Real Madrid 2 - 0 Athletic
(6, 2, 6, 3, 2, 2),   -- Barça 3 - 2 Villarreal
(6, 3, 7, 1, 1, 0),   -- Atlético 1 - 1 Betis
(6, 4, 5, 0, 3, 5);   -- Sevilla 0 - 3 Valencia

-- JORNADA 7
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(7, 1, 7, 4, 1, 1),   -- Real Madrid 4 - 1 Betis
(7, 2, 8, 2, 1, 2),   -- Barça 2 - 1 Athletic
(7, 3, 4, 2, 0, 3),   -- Atlético 2 - 0 Sevilla
(7, 5, 6, 1, 2, 6);   -- Valencia 1 - 2 Villarreal

-- JORNADA 8
INSERT INTO partidos (jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES
(8, 1, 3, 1, 1, 0),   -- Real Madrid 1 - 1 Atlético
(8, 2, 4, 2, 1, 2),   -- Barça 2 - 1 Sevilla
(8, 5, 8, 3, 0, 5),   -- Valencia 3 - 0 Athletic
(8, 6, 7, 1, 0, 6);   -- Villarreal 1 - 0 Betis

-- Fin del script (8 jornadas × 4 partidos = 32 partidos)

-- Insertar jornadas (vinculando los 4 partidos de cada jornada)
INSERT INTO jornadas (id, idPartido1, idPartido2, idPartido3, idPartido4) VALUES
(1, 1, 2, 3, 4),         -- Jornada 1: partidos 1-4
(2, 5, 6, 7, 8),         -- Jornada 2: partidos 5-8
(3, 9, 10, 11, 12),      -- Jornada 3: partidos 9-12
(4, 13, 14, 15, 16),     -- Jornada 4: partidos 13-16
(5, 17, 18, 19, 20),     -- Jornada 5: partidos 17-20
(6, 21, 22, 23, 24),     -- Jornada 6: partidos 21-24
(7, 25, 26, 27, 28),     -- Jornada 7: partidos 25-28
(8, 29, 30, 31, 32);     -- Jornada 8: partidos 29-32
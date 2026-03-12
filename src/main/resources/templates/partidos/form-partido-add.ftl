<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Partido</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <h1>CREAR PARTIDO</h1>

    <a href="/lista-partidos">Regresar al listado</a>

    <br/><br/>

        <#assign destino = "/crea-partido">

        <#assign jornada = 0>
        <#assign idEquipo1 = 0>
        <#assign idEquipo2 = 0>
        <#assign puntuacionEquipo1 = 0>
        <#assign puntuacionEquipo2 = 0>
        <#assign ganador = 0>

<form action="${destino}" method="POST">
        <div class="container">
            <div class="w25">
                <label for="jornada">Jornada</label>
                <input type="text" name="jornada" value="${jornada}">
            </div>
            <div class="w25">
                <label for="equipo1">Equipo1</label>
                <input type="text" name="equipo1" value="${idEquipo1}">
            </div><div class="w25">
                <label for="equipo2">Equipo2</label>
                <input type="text" name="equipo2" value="${idEquipo2}">
            </div>
        </div>

        <div class="container">
              <div class="w25">
                  <label for="puntuacionEquipo1">Puntuacion Local</label>
                  <input type="text" name="puntuacionEquipo1" value="${puntuacionEquipo1}">
              </div>
              <div class="w25">
                  <label for="puntuacionEquipo2">Puntuacion Visitante</label>
                  <input type="text" name="puntuacionEquipo2" value="${puntuacionEquipo2}">
              </div>
              <div class="w25">
                  <label for="ganador">Ganador</label>
                  <input type="text" name="ganador" value="${ganador}">
              </div>
        </div>
        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Editar Partido</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
       <h1>EDITAR PARTIDO</h1>

    <a href="/lista-partidos">Regresar al listado</a>

    <br/><br/>

        <#if mensajeError??>
                <div class="error">${mensajeError}</div>
        </#if>

        <#assign destino = "/editar-partido/"+partido.id>

        <form action="${destino}" method="POST">
        <div class="container">
            <div class="w25">
                <label for="id">ID</label>
                <input type="text" name="id" value="${partido.id}" disabled="disabled">
            </div>
            <div class="w25">
                <label for="jornada">Jornada</label>
                <input type="text" name="jornada" value="${partido.jornada}" readonly>
            </div>
            <div class="w25">
                <label for="idEquipo1">Equipo1</label>
                <input type="text" name="idEquipo1" value="${partido.idEquipo1}" readonly>
            </div><div class="w25">
                <label for="idEquipo2">Equipo2</label>
                <input type="text" name="idEquipo2" value="${partido.idEquipo2}" readonly>
            </div>
        </div>

        <div class="container">
                    <div class="w25">
                        <label for="puntuacionEquipo1">Puntuacion Local</label>
                        <input type="text" name="puntuacionEquipo1" value="${partido.puntuacionEquipo1}">
                    </div>
                    <div class="w25">
                        <label for="puntuacionEquipo2">Puntuacion Visitante</label>
                        <input type="text" name="puntuacionEquipo2" value="${partido.puntuacionEquipo2}">
                    </div>
                    <div class="w25">
                        <label for="ganador">Ganador</label>
                        <input type="text" name="ganador" value="${partido.ganador}">
                    </div>
                </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>
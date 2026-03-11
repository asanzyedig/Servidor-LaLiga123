<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Partido<#else>Editar Partido</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
        <#if agregar>
                <h1>CREAR PARTIDO</h1>
            <#else>
                <h1>EDITAR PARTIDO</h1>
            </#if>

    <a href="/lista-partidos">Regresar al listado</a>

    <br/><br/>

        <#if mensajeError??>
                <div class="error">${mensajeError}</div>
        </#if>

        <#assign destino = "/editar-partido/"+partido.id>

        <#if agregar>
                <#assign destino = "/crea-partido">
        </#if>

        <form action="${destino}" method="POST">
        <div class="container">
            <div class="w25">
                <label for="id">ID</label>
                <input type="text" name="id" value="${partido.id}" disabled="disabled">
            </div>
            <div class="w25">
                <label for="jornada">Jornada</label>
                <input type="text" name="jornada" value="${partido.jornada}" disabled="disabled">
            </div>
            <div class="w25">
                <label for="equipo1">Equipo1</label>
                <input type="text" name="equipo1" value="${partido.idEquipo1}" disabled="disabled">
            </div><div class="w25">
                <label for="equipo2">Equipo2</label>
                <input type="text" name="equipo2" value="${partido.idEquipo2}" disabled="disabled">
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
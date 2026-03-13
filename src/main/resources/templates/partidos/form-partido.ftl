<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Partido</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/crearUsuario.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
       <div class="main">
            <div class="logo">
                <a href="/lista-users"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
                <div class="ruta">
                    <p>Inicio / Partidos / Editar Partido</p>
                </div>
            </div>

        <#if mensajeError??>
                <div class="error">${mensajeError}</div>
        </#if>

        <#assign destino = "/editar-partido/"+partido.id>

        <form action="${destino}" method="POST">
                <div class="input-field">
                    <label for="id">ID</label>
                    <input type="text" name="id" value="${partido.id}" disabled="disabled">
                </div>
                <div class="input-field">
                    <label for="jornada">Jornada</label>
                    <input type="text" name="jornada" value="${partido.jornada}" readonly>
                </div>
                <div class="input-field">
                    <label for="idEquipo1">Equipo1</label>
                    <input type="text" name="idEquipo1" value="${partido.idEquipo1}" readonly>
                <div class="input-field">
                    <label for="idEquipo2">Equipo2</label>
                    <input type="text" name="idEquipo2" value="${partido.idEquipo2}" readonly>
                </div>
                <div class="input-field">
                    <label for="puntuacionEquipo1">Puntuacion Local</label>
                    <input type="text" name="puntuacionEquipo1" value="${partido.puntuacionEquipo1}">
                </div>
                <div class="input-field">
                    <label for="puntuacionEquipo2">Puntuacion Visitante</label>
                    <input type="text" name="puntuacionEquipo2" value="${partido.puntuacionEquipo2}">
                </div>
                <div class="input-field">
                    <label for="ganador">Ganador</label>
                    <input type="text" name="ganador" value="${partido.ganador}">
                </div>
            <div class="actions">
                <button type="submit" class="btn-main">Guardar</button>
            </div>
        </form>
        <#include "/templates/footer.ftl">
       </div>
</body>
</html>
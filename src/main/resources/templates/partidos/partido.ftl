<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Partido</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if eliminar>
        <h1>Eliminar el partido</h1>
    <#else>
        <h1>Vista del partido</h1>
    </#if>
    <a href="/lista-partidos">Volver a la lista</a>
    <br/><br/>

    <#if mensajeError??>
        <div class="error">${mensajeError}</div>
    <#else>
        <table id="users">
            <tbody><tr>
                <th>ID</th>
                <td>${partido.id}</td>
            </tr>
            <tr>
                <th>Jornada</th>
                <td>${partido.jornada}</td>
            </tr>
            <tr>
                <th>Equipo1</th>
                <td>${partido.idEquipo1}</td>
            </tr>
            <tr>
                <th>Equipo2</th>
                <td>${partido.idEquipo2}</td>
            </tr>
            <tr>
                <th>Puntuacion Local</th>
                <td>${partido.puntuacionEquipo1}</td>
            </tr>
            <tr>
                <th>Puntuacion Visitante</th>
                <td>${partido.puntuacionEquipo2}</td>
            </tr>
            <tr>
                <th>Ganador</th>
                <td>${partido.ganador}</td>
            </tr>
            </tbody>
        </table>

        <br/><br/>
        <#if eliminar>
            <!-- TIENE QUE SER POST -->
            <form action="/elimina-partido/${partido.id}" method="POST">
                ¿Seguro que desea eliminar el partido? <input type="submit" value="Confirmar" />
            </form>
        <#else>
            <div>
                <a href="/elimina-partido/${partido.id}">Eliminar</a>
                <a href="/editar-partido/${partido.id}">Editar</a>
            </div>
        </#if>
    </#if>
</body>
</html>
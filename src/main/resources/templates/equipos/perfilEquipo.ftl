<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/perfilEquipo.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">

    <title>Laliga123 - Perfil de equipo</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Inicio / Equipos / Equipo</p>
            </div>
        </div>

        <#if agregar>
            <#assign ima = "fa-solid fa-circle-user">
            <#assign esIcono = true>
            <#assign nam = "">
            <#assign sed = "">
        <#else>
            <#assign ima = (team.image)! "">
            <#assign esIcono = (ima == "")>
            <#assign nam = team.name! "">
            <#assign sed = team.sede! "">
        </#if>


        <div id="botones">
            <#if eliminar>
                <h2>¿Estás seguro de que deseas eliminar el equipo ${team.name}?</h2>
                <form action="/elimina-equipo/${team.id}" method="POST">
                    <input type="submit" value="Confirmar Eliminación">
                </form>
                <button type="button" onclick="location.href='/lista-equipos'">Cancelar</button>
            <#else>
                <form action="/guardar-equipo" method="post">

                    <input type="hidden" name="id" value="${(team.id)!0}">

                    <div class="fila-img">
                        <#if esIcono>
                            <i class="fa-solid fa-circle-user" style="font-size: 50px;"></i>
                        <#else>
                            <img src="data:image/png;base64,${ima}" alt="Logo equipo" style="width:100px;">
                        </#if>
                    </div>

                    <label for="name">Nombre:</label>
                    <input type="text" name="name" id="name" value="${nam}" required>

                    <label for="sede">Sede principal:</label>
                    <input type="text" name="sede" id="sede" value="${sed}" required>

                    <#if agregar>
                        <input type="submit" value="Crear Equipo">
                    <#else>
                        <input type="submit" value="Guardar Cambios">
                    </#if>
                </form>
                <button type="button" onclick="location.href='/lista-equipos'">Atrás</button>
            </#if>
        </div>

        <#include "/templates/footer.ftl">
    </div>
</body>
</html>

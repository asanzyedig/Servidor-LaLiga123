<!DOCTYPE html>
<html lang="en">
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

        <#if !team.image??>
            <#assign ima = "fa-solid fa-circle-user">
            <#assign esIcono = true>
        <#else>
            <#assign ima = team.image>
            <#assign esIcono = false>
        </#if>

        <div id="menu">
        </div>
            <div id="botones">
                <form action="" method="get">
                    <div class="fila-img">
                        <#if esIcono>
                            <i class="${ima}" style="font-size: 50px;"></i>
                        <#else>
                            <img src="${ima}" alt="Logo equipo">
                        </#if>
                        <label for="selImg" class="btn-file">Seleccionar imagen</label>
                        <input type="file" name="selImg" id="selImg">
                    </div>
                    <label for="name">Nombre:</label>
                    <input type="text" name="name" id="name" value="${team.name}">
                    <label for="sede">Sede principal:</label>
                    <input type="text" name="sede" id="sede" value="${team.sede}">
                </form>
                <#if !team??>
                    <button onclick="location.href='/equipos'">Crear Equipo</button>
                <#else>
                    <button onclick="location.href='/equipos'">Guardar Cambios</button>
                </#if>

                    <button onclick="location.href='/lista-equipos'">Atrás</button>
            </div>

            <#include "/templates/footer.ftl">
        </div>
    </body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laliga123 - Gestion de partidos</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/listaEquipos.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
   <div class="main">
        <div class="logo">
            <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Equipos / Lista equipos</p>
            </div>
        </div>

        
        <div id="botones">
            <div id="participantes">
                <#list teams as team>
                    <div class="participante">
                        <#if !team.image??>
                            <#assign ima = "fa-solid fa-people-group">
                            <#assign esIcono = true>
                        <#else>
                            <#assign ima = team.image>
                            <#assign esIcono = false>
                        </#if>

                        <#if esIcono>
                            <i class="${ima}" style="font-size: 50px;"></i>
                        <#else>
                            <img src="${ima}" alt="Logo equipo">
                        </#if>

                        <p>${team.name}</p>

                        <a href="/elimina-equipo/${team.id}"><i class="fa-solid fa-trash"></i></a>
                        <a href="/editar-equipo/${team.id}"><i class="fa-regular fa-pen-to-square"></i></a>
                    </div>
                    <hr>
                </#list>
            </div>
            <button onclick="location.href='/gestion-equipos'">Atrás</button>
        </div>

       <#include "/templates/footer.ftl">
    </div>
</body>
</html>
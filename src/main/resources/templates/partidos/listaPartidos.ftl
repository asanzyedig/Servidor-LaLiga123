<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laliga123 - Gestion de partidos</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
   <div class="main">
        <div class="logo">
            <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Partidos / Lista Partidos</p>
            </div>
        </div>
        <div id="botones">
            <div id="participantes">
                <#list partidos as partido>
                    <div class="participante">

                        <p>${listaEquipos[partido.idEquipo1?string]}</p>
                        <p>VS</p>
                        <p>${listaEquipos[partido.idEquipo2?string]}</p>

                        <a href="/editar-partido/${partido.id}"><i class="fa-regular fa-pen-to-square"></i></a>
                    </div>
                    <hr>
                </#list>
            </div>
            <button onclick="location.href='/inicio'">Atrás</button>
        </div>

        <#include "/templates/footer.ftl">
   </div>

</body>
</html>
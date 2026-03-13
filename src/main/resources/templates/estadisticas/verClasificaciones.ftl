<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="/css/clasificacion.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
    <title>Laliga123 - Visualizacion de clasificaciones</title>
</head>
<body>
     <div class="main">
        <div class="logo">
            <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Estadisticas / Clasificación</p>
            </div>
        </div>

        <div id="selector">
            <form method="GET" action="/clasificacion" style="display: inline;">
                <select name="jornada" id="Jornada" onchange="this.form.submit()">
                    <option value="">Selecciona jornada</option>
                    <#list jornadas as jornada>
                        <option value="${jornada}" <#if jornadaSeleccionada == jornada>selected</#if>>Jornada ${jornada}</option>
                    </#list>
                </select>
            </form>
        </div>

        <div id="clasificacion">
            <table>
                <tr>
                    <th>Posición</th>
                    <th colspan="3">Nombre del equipo</th>
                    <th>PJ</th>
                    <th>V</th>
                    <th>E</th>
                    <th>P</th>
                    <th>Puntos</th>
                </tr>
                <#list clasificaciones as equipo>
                    <#assign posicion = equipo?index + 1>
                    <tr>
                        <td>${posicion}</td>
                        <td colspan="3">
                            <#if equipo.imagen??>
                                <img src="/img/${equipo.imagen}" alt="">
                            </#if>
                            ${equipo.nombre}
                        </td>
                        <td>${equipo.pj}</td>
                        <td>${equipo.v}</td>
                        <td>${equipo.e}</td>
                        <td>${equipo.p}</td>
                        <td>${equipo.puntos}</td>
                    </tr>
                </#list>
            </table>
        </div>

        <div id="botones">
            <button onclick="location.href='/estadisticas'">Atras</button>
        </div>

        <#include "/templates/footer.ftl">
    </div>
</body>
</html>
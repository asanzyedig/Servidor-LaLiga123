<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laliga123 - Ver Partidos</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/verPartidos.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
    <div class="main">
        <div class="logo">
            <a href="/" ><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Estadísticas / Ver Partidos</p>
            </div>
        </div>

        <div id="botones">
            <form action="">
                <select name="jornada" id="Jornada" onchange="filtrarPartidos()">
                    <#if jornadas?has_content>
                        <option value="${jornadas[0]}" selected>Jornada ${jornadas[0]}</option>
                        <#list jornadas as jornada>
                            <#if jornada != jornadas[0]>
                                <option value="${jornada}">Jornada ${jornada}</option>
                            </#if>
                        </#list>
                    </#if>
                </select>
            </form>

            <#list partidos as partido>
                <div class="partidos" data-jornada="${partido.jornada}">
                    <div class="equipos">
                        <div class="caja">
                            <i class="fa-solid fa-shield"></i>
                            <p>${partido.equipo1}</p>
                        </div>
                        <p class="puntos">${partido.puntuacionEquipo1}</p>
                    </div>
                    <div class="vs">
                        <p>VS</p>
                    </div>
                    <div class="equipos">
                        <div class="caja">
                            <i class="fa-solid fa-shield"></i>
                            <p>${partido.equipo2}</p>
                        </div>
                        <p class="puntos">${partido.puntuacionEquipo2}</p>
                    </div>
                </div>
            </#list>

            <button id="atras" onclick="location.href='/estadisticas'">Atrás</button>
        </div>

        <#include "/templates/footer.ftl">
    </div>

    <script>
        function filtrarPartidos() {
            const jornadaSeleccionada = document.getElementById('Jornada').value;
            const partidos = document.querySelectorAll('.partidos');

            partidos.forEach(partido => {
                if (jornadaSeleccionada === '' || partido.dataset.jornada === jornadaSeleccionada) {
                    partido.style.display = 'flex';
                } else {
                    partido.style.display = 'none';
                }
            });
        }
        window.addEventListener('DOMContentLoaded', filtrarPartidos);
    </script>
</body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="/css/inicio.css">
    <title>LaLiga123 - Inicio</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png">
            <div class="ruta">
                <p>Inicio</p>
            </div>
        </div>

        <div id="botones">
            <button onclick="location.href='torneos/gestionTorneos.html'">Torneos</button>
            <button onclick="location.href='/lista-users'">Usuarios</button>
            <button onclick="location.href='/gestion-equipos'">Equipos</button>
            <button onclick="location.href='partidos/gestionPartidos.html'">Partidos</button>
            <button onclick="location.href='estadisticas/estadisticas.html'">Estadísticas</button>
            <button class="cerrar-sesion" onclick="location.href='/login.html'">Cerrar sesión</button>
        </div>

        <#include "footer.ftl">
    </div>
</body>
</html>
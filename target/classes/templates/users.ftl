<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" type="text/css" href="/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="/css/inicio.css">
    <title>LaLiga123 - Inicio</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png">
            <div class="ruta">
                <p>Gestión usuarios</p>
            </div>
        </div>

        <div id="botones">
            <button onclick="location.href='/lista-users'">Ver Usuarios</button>
            <button onclick="location.href='/edita-user'">Modificar Usuarios</button>
            <button onclick="location.href='/add-user'">Añadir Usuarios</button>
            <button onclick="location.href='/elimina-user'">Eliminar Usuarios</button>
            <button onclick="location.href='/inicio'">Volver</button>
        </div>

        <#include "footer.ftl">
    </div>
</body>
</html>
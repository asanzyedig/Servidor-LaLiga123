<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laliga123 - Lista de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
    <div class="main">
            <div class="logo">
                <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
                <div class="ruta">
                    <p>Usuarios / Lista Usuarios</p>
                </div>
            </div>
            <div id="botones">
                <div id="participantes">
                    <#list usuarios as user>
                        <div class="participante">

                            <p>${user.id}</p>
                            <p>${user.username}</p>

                            <a href="/elimina-user/${user.id}"><i class="fa-solid fa-trash"></i></a>
                            <a href="/edita-user/${user.id}"><i class="fa-regular fa-pen-to-square"></i></a>
                        </div>
                        <hr>
                    </#list>
                </div>
                <button onclick="location.href='/add-user'">Crear Usuario</button>
                <button onclick="location.href='/inicio'">Atrás</button>
            </div>

            <#include "/templates/footer.ftl">
       </div>
</body>
</html>
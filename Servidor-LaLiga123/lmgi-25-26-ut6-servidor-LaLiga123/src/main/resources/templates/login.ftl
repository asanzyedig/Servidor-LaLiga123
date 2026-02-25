<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/public/css/styles.css">
    <link rel="stylesheet" href="/resources/public/css/login.css">
    <link rel="stylesheet" href="/resources/public/css/footer.css">
    <link rel="stylesheet" href="/resources/public/css/all.min.css">
    <title>Login</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <img id="logo" alt="logo_laliga" src="/resources/public/img/LaLiga_123.png">
            <div class="ruta">
                <p>Inicio / Login</p>
            </div>
        </div>

        <div id="login">
            <form action="/doc/demo/inicio.html" >
            
                <input type="text" id="usuario" name="usuario" placeholder="Usuario" required>
                <input type="password" id="pass" name="pass" placeholder="Contraseña" required>
                <br>
                <br>
                <input type="submit" name="enviar" id="enviar" value="Iniciar sesion"><br>
                <a href="htmls/inicio.html">Continuar como invitado</a>
            </form>
            <br>
        </div>

        <#include "footer.ftl">

    </div>
</body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Usuario</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/crearUsuario.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>

<div class="main">
            <div class="logo">
                <a href="/inicio"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
                <div class="ruta">
                <#if eliminar>
                        <p>Inicio / Usuarios / Eliminar Usuario</p>
                    <#else>
                        <p>Inicio / Usuarios / Vista Usuario</p>
                    </#if>
                </div>
            </div>

    <#if mensajeError??>
        <div class="error">${mensajeError}</div>
    <#else>

    <#assign destino = "/lista-users">
        <form action="${destino}" method="POST" class="custom-form">
                            <div class="input-field">
                                <label for="id">ID</label>
                                <input type="text" name="id" value="${user.id}" disabled="disabled">
                            </div>
                            <div class="input-field">
                                <label for="username">Usuario</label>
                                <input type="text" name="username" value="${user.username}">
                            </div>
                            <div class="input-field">
                                <label for="password">Contraseña</label>
                                <input type="text" name="password" value="${user.password}">
                            </div>
                            <div class="input-field">
                                <label for="rol">Rol</label>
                                <input type="text" name="rol" value="${user.rol}">
                            </div>
        </form>

        <#if eliminar>
            <!-- TIENE QUE SER POST -->
            <form action="/elimina-user/${user.id}" method="POST">
                ¿Seguro que desea eliminar el usuario? <input type="submit" value="Confirmar" />
                <br><br>
            </form>
        </#if>
    </#if>

    <#include "/templates/footer.ftl">
</div>
</body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/crearUsuario.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>

        <div class="main">
                    <div class="logo">
                        <a href="/lista-users"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
                        <div class="ruta">
                            <p>Inicio / Usuarios / Editar Usuario</p>
                        </div>
                    </div>

                <#if mensajeError??>
                        <div class="error">${mensajeError}</div>
                </#if>


                <#assign destino = "/edita-user/"+user.id>

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
                    <div class="actions">
                        <button type="submit" class="btn-main">Guardar</button>
                    </div>
                </form>
                <#include "/templates/footer.ftl">
        </div>

</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Usuario<#else>Editar Usuario</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
        <#if agregar>
                <h1>CREAR USUARIO</h1>
            <#else>
                <h1>EDITAR USUARIO</h1>
            </#if>

    <a href="/lista-users">Regresar al listado</a>

    <br/><br/>

        <#if mensajeError??>
                <div class="error">${mensajeError}</div>
        </#if>

        <#assign destino = "/edita-user/"+user.id>

        <#if agregar>
                <#assign destino = "/crea-nota">
        </#if>

        <form action="${destino}" method="POST">
        <div class="container">
            <div class="w25">
                <label for="id">ID</label>
                <input type="text" name="id" value="${user.id}" disabled="disabled">
            </div>
            <div class="w25">
                <label for="username">Usuario</label>
                <input type="text" name="username" value="${user.username}">
            </div>
            <div class="w25">
                <label for="password">Contraseña</label>
                <input type="text" name="password" value="${user.password}">
            </div>
            <div class="w25">
                <label for="rol">Rol</label>
                <input type="text" name="rol" value="${user.rol}">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>
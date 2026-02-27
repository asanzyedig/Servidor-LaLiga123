<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if item??>Editar User<#else>Crear User</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if user??>
        <h1>EDITAR USER</h1>
    <#else>
        <h1>CREAR USER</h1>
    </#if>

    <a href="/lista-users">Regresar al inventario</a>

    <br/><br/>

    <#assign destino = "/add-user">
    <#assign id = user.id>
    <#assign username = "">
    <#assign password = "">
    <#assign rol = 0>

    <#if user??>
        <#assign destino = "/edita-user/"+user.id>
        <#assign id = user.id>
        <#assign username = user.username>
        <#assign password = user.password>
        <#assign rol = user.rol>
    </#if>

    <form action="${destino}" method="POST" enctype="multipart/form-data">
        <div class="container">
            <div class="w25">
                <label for="usuario">Usuario</label>
                <input type="text" id="usuario" name="usuario" value="${username}">
            </div>
            <div class="w25">
                <label for="id">ID</label>
                <input type="text" name="id" id="id" value="${id}" disabled="disabled">
            </div>
            <div class="w25">
                <label for="password">Contraseña</label>
                <input type="text" name="password" id="password" value="${password}">
            </div>
            <div class="w25">
                 <label for="rol">Rol</label>
                 <input type="text" name="rol" id="rol" value="${rol}">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

</body>
</html>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Usuario</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
        <h1>CREAR Usuario</h1>

    <a href="/lista-users">Regresar al listado</a>

    <br/><br/>

        <#assign destino = "/add-user">
    <form action="${destino}" method="POST">
        <div class="container">
            <div class="w25">
                <label for="identificador">ID</label>
                <input type="text" name="identificador" value="${user.id}">
            </div>
            <div class="w25">
                <label for="usuario">Usuario</label>
                <input type="text" name="usuario" value="${user.username}">
            </div>
            <div class="w25">
                <label for="pass">Contraseña</label>
                <input type="text" name="pass" value="${user.password}">
            </div>
            <div class="w25">
                <label for="role">Rol</label>
                <input type="text" name="role" value="${user.rol}">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>
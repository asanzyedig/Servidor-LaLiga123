<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Usuario</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <h1>CREAR USUARIO</h1>

    <a href="/lista-users">Regresar al listado</a>

    <br/><br/>

        <#assign destino = "/add-user">

      <#--  <#assign id = 0> -->

        <#assign username = "">
        <#assign password = "">
        <#assign rol = 0>

        <form action="${destino}" method="POST">
        <div class="container">
        <#--
            <div class="w25">
                <label for="id">ID</label>
                <input type="text" name="id" value="${id}">
            </div>
           -->
            <div class="w25">
                <label for="username">Usuario</label>
                <input type="text" name="username" value="${username}">
            </div>
            <div class="w25">
                <label for="password">Contraseña</label>
                <input type="text" name="password" value="${password}">
            </div>
            <div class="w25">
                <label for="rol">Rol</label>
                <input type="text" name="rol" value="${rol}">
            </div>
        </div>

        <input type="submit" value="Guardar">
    </form>

    <br/>

</body>
</html>
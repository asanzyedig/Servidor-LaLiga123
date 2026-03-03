<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Usuario</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
    <#if eliminar>
        <h1>Eliminar el usuario</h1>
    <#else>
        <h1>Vista del usuario</h1>
    </#if>
    <a href="/lista-users">Volver a la lista</a>
    <br/><br/>

    <#if mensajeError??>
        <div class="error">${mensajeError}</div>
    <#else>
        <table id="users">
            <tbody><tr>
                <th>ID</th>
                <td>${user.id}</td>
            </tr>
            <tr>
                <th>Usuario</th>
                <td>${user.username}</td>
            </tr>
            <tr>
                <th>Contraseña</th>
                <td>${user.password}</td>
            </tr>
            <tr>
                <th>Rol</th>
                <td>${user.rol}</td>
            </tr>
            </tbody>
        </table>

        <br/><br/>
        <#if eliminar>
            <!-- TIENE QUE SER POST -->
            <form action="/elimina-user/${user.id}" method="POST">
                ¿Seguro que desea eliminar el usuario? <input type="submit" value="Confirmar" />
            </form>
        <#else>
            <div>
                <a href="/elimina-user/${user.id}">Eliminar</a>
                <a href="/edita-user/${user.id}">Editar</a>
            </div>
        </#if>
    </#if>
</body>
</html>
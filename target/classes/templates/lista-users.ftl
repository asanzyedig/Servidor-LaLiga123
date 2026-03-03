<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Usuarios</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
</head>
<body>
<h1>Usuarios</h1>
<div>
    <a class="btn" href="/inicio">Volver al inicio</a>
    <a class="btn" href="/add-user">Añadir usuario</a>
</div>
<br/><br/>
<div>
    <table id="users">
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Usuario</th>
                    <th>Contraseña</th>
                    <th>Rol</th>
                </tr>
                <#list usuarios as user>
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.rol}</td>
                        <td><a href="/edita-user/${user.id}">Editar</a></td>
                        <td><a href="/elimina-user/${user.id}">Borrar</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
</div>
</body>
</html>
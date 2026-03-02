<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/estilos/styles.css">
    <link rel="stylesheet" href="/estilos/perfilEquipo.css">
    <link rel="stylesheet" href="/estilos/footer.css">
    <link rel="stylesheet" href="/estilos/all.min.css">
    <title>Laliga123 - Perfil de equipo</title>
</head>
<body>
    <div class="main">
        <div class="logo">
                <a href="/htmls/inicio.html"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
                <div class="ruta">
                    <p>Inicio / Equipos / Participantes</p>
                </div>
            </div>

        <div id="menu">
        </div>
            <div id="botones">
                <form action="" method="get">
                    <div class="fila-img"> <img src="${team.image}" alt="">
                        <label for="selImg" class="btn-file">Seleccionar imagen</label>
                        <input type="file" name="selImg" id="selImg">
                    </div>
                    <label for="name">Nombre:</label>
                    <input type="text" name="name" id="name" value="${team.name}">
                    <label for="sede">Sede principal:</label>
                    <input type="text" name="sede" id="sede" value="${team.sede}">
                </form>
                    <button onclick="location.href='/equipos'">Crear Equipo</button>
                    <button onclick="location.href='/equipos'">Atrás</button>
            </div>

            <#include "footer.ftl">
        </div>
    </body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Laliga123 - Gestion de partidos</title>
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
    <link rel="stylesheet" href="/css/gestionPartidos.css">
</head>
<body>
   <div class="main">
        <div class="logo">
            <a href="/htmls/inicio.html"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Partidos</p>
            </div>
        </div>
        
        
        
        <div id="botones">
            <form action="" method="post">
            <select name="torneo" id="torneo" required>
                <option value="">Elige un torneo</option>
                <option value="torneo1">Torneo1</option>
            </select>
            <br>
            <select name="jornada" id="jornada" required>
                <option value="">Elige una jornada</option>
                <option value="jornada1">Jornada1</option>
                <option value="jornada2">Jornada2</option>
            </select>
            <br>
            <select name="partido" id="partido" required>
                <option value="">Elige un partido</option>
                <option value="partido1">Partido1</option>
                <option value="partido2">Partido2</option>
            </select>
            <br>
            <button onclick="location.href='modPuntuaciones.html'">Modificar</button>
            
        </form>
            
            <button onclick="location.href='/inicio'">Atrás</button>
        </div>

        <#include "/templates/footer.ftl">
    </div>
    
</body>
</html>
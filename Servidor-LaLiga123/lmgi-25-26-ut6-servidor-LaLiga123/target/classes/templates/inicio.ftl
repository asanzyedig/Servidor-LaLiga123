<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/src/main/resources/public/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/src/main/resources/public/css/footer.css">
    <link rel="stylesheet" type="text/css" href="/src/main/resources/public/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="/src/main/resources/public/css/inicio.css">
    <title>LaLiga123 - Inicio</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png">
            <div class="ruta">
                <p>Inicio</p>
            </div>
        </div>

        <div id="botones">
            <button onclick="location.href='torneos/gestionTorneos.html'">Torneos</button>
            <button onclick="location.href='equipos/gestionEquipos.html'">Equipos</button>
            <button onclick="location.href='partidos/gestionPartidos.html'">Partidos</button>
            <button onclick="location.href='estadisticas/estadisticas.html'">Estadísticas</button>
            <button class="cerrar-sesion" onclick="location.href='/login.html'">Cerrar sesión</button>
        </div>

        <footer>
            <p>© 2026 LaLiga123. Todos los derechos reservados.</p>
            <div class="links">
                <ul>
                    <li><a class="textos" href="https://portal.mineco.gob.es/es-es/ministerio/Paginas/Politica_de_privacidad.aspx">Política de Privacidad</a></li>
                    <li><a class="textos" href="https://policies.google.com/terms?hl=es">Términos y Condiciones</a></li>
                </ul>
            </div>
            
            <div class="social-media">
                <a href="https://www.facebook.com">
                    <i class="fa-brands fa-facebook"></i>
                </a>
                <a href="https://x.com">
                    <i class="fa-brands fa-x-twitter"></i>
                </a>
            </div>
        </footer>
    </div>
</body>
</html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LaLiga123 - Gestion de torneos</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
    <link rel="stylesheet" href="/estilos/gestionPartidos.css">
</head>
<body>
    <div class="main">
        <div class="logo">
            <a href="/htmls/inicio.html"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Inicio / Equipos</p>
            </div>
        </div>

        <div id="botones">
        <#-- comentado hasta que se apliquen los torneos
            <select name="torneo" id="torneo" required>
                <option value="">Elige un torneo</option>
                <option value="torneo1">Torneo1</option>
                <option value="torneo2">Torneo2</option>
                <option value="torneo3">Torneo3</option>
            </select>
            <br>
        -->

            <button onclick="location.href='/crear-equipo'">Crear Equipos</button>
            <button onclick="location.href='/lista-equipos'">Modificar equipos</button>
            <button onclick="location.href='/inicio'">Atrás</button>
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
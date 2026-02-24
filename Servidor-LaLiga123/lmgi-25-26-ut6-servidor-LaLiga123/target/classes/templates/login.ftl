<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/footer.css">
    <link rel="stylesheet" href="css/all.min.css">
    <title>Login</title>
</head>
<body>
    <div class="main">
        <div class="logo">
            <img id="logo" alt="logo_laliga" src="img/LaLiga_123.png">
            <div class="ruta">
                <p>Inicio / Login</p>
            </div>
        </div>

        <div id="login">
            <form action="/doc/demo/inicio.html" >
            
                <input type="text" id="usuario" name="usuario" placeholder="Usuario" required>
                <input type="password" id="pass" name="pass" placeholder="Contraseña" required>
                <br>
                <br>
                <input type="submit" name="enviar" id="enviar" value="Iniciar sesion"><br>
                <a href="htmls/inicio.html">Continuar como invitado</a>
            </form>
            <br>
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
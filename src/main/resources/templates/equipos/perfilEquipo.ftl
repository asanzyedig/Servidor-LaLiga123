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
                <div class="fila-img"> <img src="/img/barcelona-fc.jpg" alt=""> 
                    <label for="selImg" class="btn-file">Seleccionar imagen</label>
                    <input type="file" name="selImg" id="selImg"> 
                </div>
                <label for="name">Nombre:</label>
                <input type="text" name="name" id="name">
                <label for="sede">Sede principal:</label>
                <input type="text" name="sede" id="sede">
            </form>     
                <button onclick="location.href='gestionEquipos.html'">Crear Equipo</button>
                <button onclick="location.href='gestionEquipos.html'">Atrás</button>
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
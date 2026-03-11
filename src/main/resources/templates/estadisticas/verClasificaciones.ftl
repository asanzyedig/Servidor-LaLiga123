<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
    <link rel="stylesheet" href="/css/clasificacion.css">
    <link rel="stylesheet" type="text/css" href="/css/footer.css">
    <link rel="stylesheet" href="/css/fontawesome-free-7.1.0-web/css/all.min.css">
    <title>Laliga123 - Visualizacion de clasificaciones</title>
</head>
<body>
     <div class="main">
        <div class="logo">
            <a href="/htmls/inicio.html"><img id="logo" alt="logo_laliga" src="/img/LaLiga_123.png"></a>
            <div class="ruta">
                <p>Estadisticas / Clasificación</p>
            </div>
        </div>

        <div id="selector">
            <select name="Jornada" id="Jornada">
                <option value="Default">Selecciona jornada</option>
                <option value="J1">Jornada 1</option>
                <option value="J2">Jornada 2</option>
                <option value="J3">Jornada 3</option>
                <option value="J4">Jornada 4</option>
                <option value="J5">Jornada 5</option>
                <option value="J6">Jornada 6</option>
                <option value="J7">Jornada 7</option>
                <option value="J8">Jornada 8</option>
                <option value="J9">Jornada 9</option>
                <option value="J10">Jornada 10</option>
                <option value="J11">Jornada 11</option>
                <option value="J12">Jornada 12</option>
            </select>
        </div>

        <div id="clasificacion">
            <table>
                <tr>
                    <th>Posición</th>
                    <th colspan="3">Nombre del equipo</th>
                    <th>PJ</th>
                    <th>V</th>
                    <th>E</th>
                    <th>P</th>
                    <th>Puntos</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Barcelona</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>81</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Real Madrid</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>79</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Villarreal</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>73</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Betis</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>70</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Valencia</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>66</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Sevilla</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>59</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Levante</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>51</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td colspan="3"><img src="/img/barcelona-fc.jpg" alt=""> Elche</td>
                    <td>14</td>
                    <td>10</td>
                    <td>5</td>
                    <td>2</td>
                    <td>45</td>
                </tr>
            </table>
        </div>

        <div id="botones">
            <button onclick="location.href='/estadisticas'">Atras</button>
        </div>

        <#include "/templates/footer.ftl">
    </div>
</body>
</html>
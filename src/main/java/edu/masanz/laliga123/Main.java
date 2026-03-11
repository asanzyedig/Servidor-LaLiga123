package edu.masanz.laliga123;

import edu.masanz.laliga123.controller.EquiposController;
import edu.masanz.laliga123.controller.EstadisticasController;
import edu.masanz.laliga123.controller.PartidosController;
import edu.masanz.laliga123.controller.UsersController;
import edu.masanz.laliga123.database.ConnectionManager;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        ConnectionManager.conectar("LaLiga123","root","root");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(7070);

        app.get("/", UsersController::principal);

        app.get("/login", UsersController::login);
        app.post("/login", UsersController::hacerLogin);

        app.get("/inicio", UsersController::inicio);

        //Usuarios
        app.get("/lista-users", UsersController::listarUsers);
        app.get("/user/{id}", UsersController::servirUser);
        app.get("/edita-user/{id}", UsersController::editaUser);
        app.post("/edita-user/{id}", UsersController::editarUser);
        app.get("/add-user", UsersController::addUser);
        app.post("/add-user", UsersController::crearUser);
        app.get("/elimina-user/{id}", UsersController::delUser);
        app.post("/elimina-user/{id}", UsersController::eliminarUser);

        // Equipos
        app.get("/gestion-equipos", EquiposController::gestionEquipos);
        app.get("/lista-equipos", EquiposController::listarEquipos);
        app.get("/perfil-equipo/{id}", EquiposController::mostrarPerfil);
        app.get("/crear-equipo", EquiposController::addEquipo);
        app.post("/crear-equipo", EquiposController::crearEquipo);
        app.get("/editar-equipo/{id}", EquiposController::verEditarEquipo);
        app.post("/guardar-equipo", EquiposController::guardarEquipo);
        app.get("/elimina-equipo/{id}", EquiposController::delEquipo);
        app.post("/elimina-equipo/{id}", EquiposController::eliminarEquipo);

        // Estadisticas
        app.get("/estadisticas", EstadisticasController::estadisticas);
        app.get("/clasificacion", EstadisticasController::verClasificacion);
        app.get("/partidos", EstadisticasController::verPartidos);

        // Partidos
        app.get("/lista-partidos", PartidosController::listarPartidos);
        app.get("/partido/{id}", PartidosController::servirPartido);
        app.get("/editar-partido/{id}", PartidosController::verEditarPartido);
        app.post("/editar-partido/{id}", PartidosController::editarPartido);
    }

}
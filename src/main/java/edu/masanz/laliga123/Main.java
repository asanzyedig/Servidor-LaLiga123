package edu.masanz.laliga123;

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

        ConnectionManager.conectar("LaLiga123","root","roo7");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(8080);

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
    }

}
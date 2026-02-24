package edu.masanz.laliga123;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.rendering.template.JavalinFreemarker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(8080);

        //InventarioDaoDb.inicializarInventario();

        // PRINCIPAL
        app.get("/", Main::ejemplo);

    }

    private static void ejemplo(@NotNull Context context) {

        Map<String , Object> model = new HashMap<>();
        context.render("/templates/index.ftl", model);
    }
}
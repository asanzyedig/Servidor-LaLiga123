package edu.masanz.laliga123.controller;

import edu.masanz.laliga123.model.Partido;
import edu.masanz.laliga123.service.PartidosService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidosController {


    public static void gestionPartidos(@NotNull Context context) {

        context.render("/templates/partidos/gestionPartidos.ftl");
    }

    public static void listarPartidos(@NotNull Context context) {
        Map<String,Object> model = new HashMap<>();

        List<Partido> partidos = PartidosService.obtenerPartidos();
        model.put("partidos", partidos);
        context.render("/templates/partidos/listaPartidos.ftl", model);

    }
}

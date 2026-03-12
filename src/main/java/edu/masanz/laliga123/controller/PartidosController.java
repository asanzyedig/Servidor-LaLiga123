package edu.masanz.laliga123.controller;

import edu.masanz.laliga123.model.Partido;
import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.model.User;
import edu.masanz.laliga123.service.PartidosService;
import edu.masanz.laliga123.service.TeamService;
import edu.masanz.laliga123.service.UsersService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartidosController {

    public static void listarPartidos(@NotNull Context context) {
        Map<String,Object> model = new HashMap<>();

        List<Partido> partidos = PartidosService.obtenerPartidos();
        model.put("partidos", partidos);

        List<Team> equipos = TeamService.obtenerEquipos();

        Map<String, String> listaEquipos = new HashMap<>();
        for (Team t : equipos) {
            listaEquipos.put(String.valueOf(t.getId()), t.getName());
        }

        model.put("listaEquipos", listaEquipos);
        context.render("/templates/partidos/listaPartidos.ftl", model);
    }


    public static void verEditarPartido(@NotNull Context context) {

        int idPartido = Integer.parseInt(context.pathParam("id"));

        Map<String, Object> model = new HashMap<>();
        Partido partido = PartidosService.obtenerPartido(idPartido);
        model.put("partido", partido);

        if (idPartido == 0) {
            model.put("mensajeError", "Partido no encontrado");
        }
        context.render("/templates/partidos/form-partido.ftl", model);
    }

    public static void editarPartido(@NotNull Context context) {

        int idPartido = Integer.parseInt(context.pathParam("id"));
        int jornada = Integer.parseInt(context.formParam("jornada"));
        int idEquipo1 = Integer.parseInt(context.formParam("idEquipo1"));
        int idEquipo2 = Integer.parseInt(context.formParam("idEquipo2"));
        int puntuacionEquipo1 = Integer.parseInt(context.formParam("puntuacionEquipo1"));
        int puntuacionEquipo2 = Integer.parseInt(context.formParam("puntuacionEquipo2"));
        int ganador = Integer.parseInt(context.formParam("ganador"));
        Partido partido = new Partido(idPartido,jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador);
        if (PartidosService.actualizarPartido(partido)) {
            context.redirect("/partido/" + partido.getId());
        }
    }

    public static void servirPartido(@NotNull Context context) {

        int idPartido = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Partido partido = PartidosService.obtenerPartido(idPartido);
        model.put("partido",partido);
        if (partido.getId() == 0) {
            model.put("mensajeError", "Partido no encontrado");
        }
        context.render("/templates/partidos/partido.ftl", model);
    }
}

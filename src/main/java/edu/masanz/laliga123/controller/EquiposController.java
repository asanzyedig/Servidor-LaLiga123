package edu.masanz.laliga123.controller;

import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.service.TeamService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class EquiposController {


    public static void mostrarPerfil(@NotNull Context context) {
        int idEquipo = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Team team = TeamService.obtenerEquipo(idEquipo);

        if (team.getId() > 0){
            model.put("team", team);
        } else if (team.getId() == 0) {
            model.put("mensajeError", "Equipo no encontrada");
        }
        context.render("/templates/equipos/perfilEquipo.ftl", model);
    }
}

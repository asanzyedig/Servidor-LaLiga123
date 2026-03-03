package edu.masanz.laliga123.controller;

import edu.masanz.laliga123.dao.ITeamDao;
import edu.masanz.laliga123.dao.UsersDao;
import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.model.User;
import edu.masanz.laliga123.service.TeamService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
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

    public static void listarEquipos(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();

        List<Team> teams = ITeamDao.obtenerTeams();

        model.put("teams", teams);

        context.render("/templates/equipos/listaEquipos.ftl", model);
    }

    public static void gestionEquipos(@NotNull Context context) {
        context.render("/templates/equipos/gestionEquipos.ftl");
    }

    public static void crearEquipo(@NotNull Context context) {
    }
}

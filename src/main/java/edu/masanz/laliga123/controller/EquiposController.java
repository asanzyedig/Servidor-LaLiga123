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
        String nombre = context.formParam("name");
        String sede = context.formParam("sede");
        String image = context.formParam("image");
        Team team = new Team(nombre, sede, image);
        team = TeamService.guardarEquipo(team);
        if (team.getId() != 0) {
            context.redirect("/lista-equipos");
        }
    }

    public static void servirCrearEquipo(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        Team team = new Team();
        model.put("agregar", true);
        model.put("team", team);
        context.render("/templates/equipos/perfilEquipo.ftl", model);
    }

    public static void servirEditarEquipo(Context context){
        int idTeam = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Team team = TeamService.obtenerTeam(idTeam);
        model.put("agregar", false);
        model.put("team", team);
        if (team.getId() == 0) {
            model.put("mensajeError", "Equipo no encontrado");
        }
        context.render("/templates/equipos/perfilEquipo.ftl", model);
    }

    public static void editarEquipo(Context context){
        int idTeam = Integer.parseInt(context.pathParam("id"));
        String nombre = context.formParam("name");
        String sede = context.formParam("sede");
        Team team = new Team(idTeam, nombre, sede);
        if (TeamService.actualizarTeam(team)) {
            context.redirect("/templates/equipos/perfilEquipo.ftl" + team.getId());
        }else {
            context.redirect("/error");
        }
    }

    public static void servirEliminarEquipo(Context context){
        int idTeam = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Team team = TeamService.obtenerTeam(idTeam);
        model.put("eliminar", true);
        model.put("team", team);
        if (team.getId() == 0) {
            model.put("mensajeError", "Equipo no encontrado");
        }
        context.render("/templates/equipos/perfilEquipo.ftl", model);
    }

    public static void eliminarEquipo(Context context){
        int idTeam = Integer.parseInt(context.pathParam("id"));
        if (TeamService.eliminarNota(idTeam)) {
            context.redirect("/lista-equipos");
        }else {
            context.redirect("/error");
        }
    }
}

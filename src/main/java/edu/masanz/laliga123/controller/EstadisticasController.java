package edu.masanz.laliga123.controller;

import edu.masanz.laliga123.model.Partido;
import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.service.PartidosService;
import edu.masanz.laliga123.service.TeamService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class EstadisticasController {
    public static void estadisticas(@NotNull Context context) {
        context.render("/templates/estadisticas/estadisticas.ftl");
    }

    public static void verClasificacion(@NotNull Context context) {
        context.render("/templates/estadisticas/verClasificaciones.ftl");
    }

    public static void verPartidos(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        List<Partido> partidos = PartidosService.obtenerPartidos(); // lista con los partidos

        List<Map<String, Object>> partidosInfo = new ArrayList<>();
        Set<Integer> jornadasSet = new TreeSet<>();

        for (Partido p : partidos) {
            Map<String, Object> partidoMap = new HashMap<>();
            partidoMap.put("id", p.getId());
            partidoMap.put("jornada", p.getJornada());

            Team equipo1 = TeamService.obtenerTeam(p.getIdEquipo1());
            Team equipo2 = TeamService.obtenerTeam(p.getIdEquipo2());

            if (equipo1 != null) {
                partidoMap.put("equipo1", equipo1.getName());
            } else {
                partidoMap.put("equipo1", "Equipo " + p.getIdEquipo1());
            }

            if (equipo2 != null) {
                partidoMap.put("equipo2", equipo2.getName());
            } else {
                partidoMap.put("equipo2", "Equipo " + p.getIdEquipo2());
            }

            partidoMap.put("puntuacionEquipo1", p.getPuntuacionEquipo1());
            partidoMap.put("puntuacionEquipo2", p.getPuntuacionEquipo2());
            partidoMap.put("ganador", p.getGanador());

            partidosInfo.add(partidoMap);
            jornadasSet.add(p.getJornada());
        }

        List<Integer> jornadas = new ArrayList<>(jornadasSet);
        Collections.sort(jornadas);

        model.put("partidos", partidosInfo);
        model.put("jornadas", jornadas);

        context.render("/templates/estadisticas/verPartidos.ftl", model);
    }
}

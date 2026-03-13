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

        // Recupera la lista de objetos 'Partido' desde la base de datos
        List<Partido> partidos = PartidosService.obtenerPartidos();

        // Lista para guardar los partidos procesados (con nombres en vez de IDs)
        List<Map<String, Object>> partidosInfo = new ArrayList<>();

        // Set para recolectar qué números de jornada existen (TreeSet los mantiene únicos y ordenados)
        Set<Integer> jornadasSet = new TreeSet<>();

        // Iteramos por cada partido crudo obtenido de la BD
        for (Partido p : partidos) {
            Map<String, Object> partidoMap = new HashMap<>();
            partidoMap.put("id", p.getId());
            partidoMap.put("jornada", p.getJornada());

            // Buscamos los objetos Team para obtener los nombres reales
            Team equipo1 = TeamService.obtenerTeam(p.getIdEquipo1());
            Team equipo2 = TeamService.obtenerTeam(p.getIdEquipo2());

            // Si el equipo existe, usamos su nombre; si no, ponemos un texto por defecto
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

            // Añadimos el resto de datos del partido al mapa individual
            partidoMap.put("puntuacionEquipo1", p.getPuntuacionEquipo1());
            partidoMap.put("puntuacionEquipo2", p.getPuntuacionEquipo2());
            partidoMap.put("ganador", p.getGanador());

            // Guardamos el partido procesado en la lista general
            partidosInfo.add(partidoMap);

            // Registramos el número de jornada para saber cuántas hay en total
            jornadasSet.add(p.getJornada());
        }

        // Convertimos el Set de jornadas a una lista para poder ordenarla y recorrerla fácilmente
        List<Integer> jornadas = new ArrayList<>(jornadasSet);
        Collections.sort(jornadas);

        model.put("partidos", partidosInfo);
        model.put("jornadas", jornadas);

        context.render("/templates/estadisticas/verPartidos.ftl", model);
    }
}

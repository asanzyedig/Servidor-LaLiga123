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
        Map<String, Object> model = new HashMap<>();

        // Recupera la lista de objetos 'Partido' desde la base de datos
        List<Partido> partidos = PartidosService.obtenerPartidos();

        // Set para recolectar qué números de jornada existen
        Set<Integer> jornadasSet = new TreeSet<>();
        for (Partido p : partidos) {
            jornadasSet.add(p.getJornada());
        }

        // Leemos posible parámetro de consulta 'jornada'
        String jornadaParam = context.queryParam("jornada");
        Integer jornadaSeleccionada = null;
        if (jornadaParam != null && !jornadaParam.isEmpty()) {
            jornadaSeleccionada = Integer.parseInt(jornadaParam);
        }

        // Inicializamos la tabla con todos los equipos
        Map<Integer, Map<String, Object>> tabla = new HashMap<>();
        List<Team> equipos = TeamService.obtenerEquipos();
        for (Team t : equipos) {
            Map<String, Object> fila = new HashMap<>();
            fila.put("id", t.getId());
            fila.put("nombre", t.getName());
            fila.put("imagen", t.getImage());
            fila.put("pj", 0);
            fila.put("v", 0);
            fila.put("e", 0);
            fila.put("p", 0);
            fila.put("puntos", 0);
            tabla.put(t.getId(), fila);
        }

        // Procesamos los partidos
        for (Partido p : partidos) {
            // Filtramos por jornada si se indicó
            if (jornadaSeleccionada != null && p.getJornada() != jornadaSeleccionada) {
                continue;
            }

            int id1 = p.getIdEquipo1();
            int id2 = p.getIdEquipo2();

            Map<String, Object> fila1 = tabla.get(id1);
            Map<String, Object> fila2 = tabla.get(id2);

            // Actualizar PJ
            fila1.put("pj", ((Integer) fila1.get("pj")) + 1);
            fila2.put("pj", ((Integer) fila2.get("pj")) + 1);

            int g1 = p.getPuntuacionEquipo1();
            int g2 = p.getPuntuacionEquipo2();

            // Actualizar victorias, empates, derrotas
            if (g1 > g2) {
                fila1.put("v", ((Integer) fila1.get("v")) + 1);
                fila2.put("p", ((Integer) fila2.get("p")) + 1);
            } else if (g1 < g2) {
                fila2.put("v", ((Integer) fila2.get("v")) + 1);
                fila1.put("p", ((Integer) fila1.get("p")) + 1);
            } else {
                fila1.put("e", ((Integer) fila1.get("e")) + 1);
                fila2.put("e", ((Integer) fila2.get("e")) + 1);
            }

            // Recalcular puntos
            int puntos1 = ((Integer) fila1.get("v")) * 3 + ((Integer) fila1.get("e"));
            int puntos2 = ((Integer) fila2.get("v")) * 3 + ((Integer) fila2.get("e"));
            fila1.put("puntos", puntos1);
            fila2.put("puntos", puntos2);
        }

        // Construimos la lista ordenada por puntos (desc), victorias (desc) y nombre
        List<Map<String, Object>> clasificaciones = new ArrayList<>(tabla.values());
        clasificaciones.sort((a, b) -> {
            int pa = (Integer) a.get("puntos");
            int pb = (Integer) b.get("puntos");
            if (pb != pa) return Integer.compare(pb, pa);
            int va = (Integer) a.get("v");
            int vb = (Integer) b.get("v");
            if (vb != va) return Integer.compare(vb, va);
            String na = (String) a.get("nombre");
            String nb = (String) b.get("nombre");
            return na.compareToIgnoreCase(nb);
        });

        model.put("jornadas", new ArrayList<>(jornadasSet));
        model.put("jornadaSeleccionada", jornadaSeleccionada);
        model.put("clasificaciones", clasificaciones);

        context.render("/templates/estadisticas/verClasificaciones.ftl", model);
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

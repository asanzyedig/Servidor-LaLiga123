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

        // Obtener todos los partidos
        List<Partido> partidos = PartidosService.obtenerPartidos();
        
        // Obtener todos los equipos
        List<Team> equipos = TeamService.obtenerTeams();
        
        // Set para recolectar números de jornada
        Set<Integer> jornadasSet = new TreeSet<>();
        
        // Estructura para guardar estadísticas por equipo y por jornada
        // Map<idEquipo, Map<jornada, estadísticas>>
        Map<Integer, Map<Integer, Map<String, Object>>> estadisticasPorEquipoYJornada = new HashMap<>();
        
        // Inicializar estructura de datos para cada equipo
        for (Team team : equipos) {
            estadisticasPorEquipoYJornada.put(team.getId(), new HashMap<>());
        }
        
        // Procesar partidos ordenados
        List<Partido> partidosOrdenados = new ArrayList<>(partidos);
        partidosOrdenados.sort((a, b) -> Integer.compare(a.getJornada(), b.getJornada()));
        
        // Procesar cada partido
        for (Partido p : partidosOrdenados) {
            jornadasSet.add(p.getJornada());
            
            int idEquipo1 = p.getIdEquipo1();
            int idEquipo2 = p.getIdEquipo2();
            int jornada = p.getJornada();
            
            // Obtener estadísticas de la jornada anterior para acumular
            Map<String, Object> statsAnterior1 = obtenerEstadisticasJornada(
                estadisticasPorEquipoYJornada, idEquipo1, jornada - 1
            );
            Map<String, Object> statsAnterior2 = obtenerEstadisticasJornada(
                estadisticasPorEquipoYJornada, idEquipo2, jornada - 1
            );
            
            // Crear nuevas estadísticas para esta jornada basadas en la anterior
            Map<String, Object> stats1 = new HashMap<>(statsAnterior1);
            Map<String, Object> stats2 = new HashMap<>(statsAnterior2);
            
            // Incrementar partidos jugados
            stats1.put("pj", (int)stats1.get("pj") + 1);
            stats2.put("pj", (int)stats2.get("pj") + 1);
            
            // Determinar resultado (ganador: 1=equipo1, 2=equipo2, 0=empate)
            if (p.getGanador() == 1) {
                // Equipo1 gana
                stats1.put("v", (int)stats1.get("v") + 1);
                stats1.put("puntos", (int)stats1.get("puntos") + 3);
                stats2.put("p", (int)stats2.get("p") + 1);
                stats2.put("puntos", (int)stats2.get("puntos") + 1);
            } else if (p.getGanador() == 2) {
                // Equipo2 gana
                stats2.put("v", (int)stats2.get("v") + 1);
                stats2.put("puntos", (int)stats2.get("puntos") + 3);
                stats1.put("p", (int)stats1.get("p") + 1);
                stats1.put("puntos", (int)stats1.get("puntos") + 1);
            } else {
                // Empate
                stats1.put("e", (int)stats1.get("e") + 1);
                stats1.put("puntos", (int)stats1.get("puntos") + 2);
                stats2.put("e", (int)stats2.get("e") + 1);
                stats2.put("puntos", (int)stats2.get("puntos") + 2);
            }
            
            // Guardar estadísticas de esta jornada
            estadisticasPorEquipoYJornada.get(idEquipo1).put(jornada, stats1);
            estadisticasPorEquipoYJornada.get(idEquipo2).put(jornada, stats2);
        }
        
        // Obtener jornadas ordenadas
        List<Integer> jornadas = new ArrayList<>(jornadasSet);
        Collections.sort(jornadas);
        
        // Obtener la jornada seleccionada (por defecto la última)
        int jornadaSeleccionada = jornadas.isEmpty() ? 0 : jornadas.get(jornadas.size() - 1);
        String jornadaParam = context.queryParam("jornada");
        if (jornadaParam != null && !jornadaParam.isEmpty()) {
            try {
                int jornada = Integer.parseInt(jornadaParam);
                if (jornadas.contains(jornada)) {
                    jornadaSeleccionada = jornada;
                }
            } catch (NumberFormatException e) {
                // Usar la jornada por defecto
            }
        }
        
        // Construir datos para el template con la jornada seleccionada
        List<Map<String, Object>> clasificaciones = new ArrayList<>();
        
        for (Team team : equipos) {
            Map<String, Object> equipoStats = new HashMap<>();
            equipoStats.put("id", team.getId());
            equipoStats.put("nombre", team.getName());
            equipoStats.put("imagen", team.getImage());
            
            // Obtener estadísticas de la jornada seleccionada
            Map<String, Object> stats = estadisticasPorEquipoYJornada.get(team.getId()).get(jornadaSeleccionada);
            if (stats != null) {
                equipoStats.putAll(stats);
            } else {
                equipoStats.putAll(inicializarEstadisticas());
            }
            
            clasificaciones.add(equipoStats);
        }
        
        // Ordenar por puntos (descendente)
        clasificaciones.sort((a, b) -> {
            int puntosA = (int)a.get("puntos");
            int puntosB = (int)b.get("puntos");
            return puntosB - puntosA;
        });
        
        model.put("clasificaciones", clasificaciones);
        model.put("jornadas", jornadas);
        model.put("jornadaSeleccionada", jornadaSeleccionada);
        
        context.render("/templates/estadisticas/verClasificaciones.ftl", model);
    }
    
    private static Map<String, Object> obtenerEstadisticasJornada(
            Map<Integer, Map<Integer, Map<String, Object>>> estadisticas, 
            int idEquipo, 
            int jornada) {
        
        if (jornada <= 0 || !estadisticas.containsKey(idEquipo)) {
            return inicializarEstadisticas();
        }
        
        Map<String, Object> stats = estadisticas.get(idEquipo).get(jornada);
        if (stats != null) {
            return new HashMap<>(stats);
        }
        
        return inicializarEstadisticas();
    }
    
    private static Map<String, Object> inicializarEstadisticas() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("pj", 0);
        stats.put("v", 0);
        stats.put("e", 0);
        stats.put("p", 0);
        stats.put("puntos", 0);
        return stats;
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

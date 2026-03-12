package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.Partido;
import edu.masanz.laliga123.model.User;

import java.util.ArrayList;
import java.util.List;

public class PartidosDao {
    public static List<Partido> obtenerPartidos() {

        List<Partido> partidos = new ArrayList<>();

        String sql = "SELECT id, jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador FROM partidos";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length>0) {
            for(int i = 0; i < resultado.length; i++) {
                Partido partido = new Partido();
                partido.setId((Integer) resultado[i][0]);
                partido.setJornada((Integer) resultado[i][1]);
                partido.setIdEquipo1((Integer) resultado[i][2]);
                partido.setIdEquipo2((Integer) resultado[i][3]);
                partido.setPuntuacionEquipo1((Integer) resultado[i][4]);
                partido.setPuntuacionEquipo2((Integer) resultado[i][5]);
                partido.setGanador((Integer) resultado[i][6]);
                partidos.add(partido);
            }
        }
        return partidos;
    }

    public static Partido obtenerPartidos(int idPartido) {

        String sql = "SELECT id, jornada, idEquipo1, idEquipo2, puntuacionEquipo1, puntuacionEquipo2, ganador FROM partidos WHERE id = ? ORDER BY id DESC LIMIT 1";
        Object[] params = {idPartido};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length == 1) {
            Partido partido = new Partido();

           partido.setId( (int) resultado[0][0]);
           partido.setJornada((int) resultado[0][1]);
           partido.setIdEquipo1((int) resultado[0][2]);
           partido.setIdEquipo2( (int) resultado[0][3]);
           partido.setPuntuacionEquipo1( (int) resultado[0][4]);
           partido.setPuntuacionEquipo2( (int) resultado[0][5]);
           partido.setGanador( (int) resultado[0][6]);

            return partido;
        }
        return null;
    }

    public static boolean actualizarPartido(Partido partido) {

        String sql = "UPDATE partidos SET jornada = ?, idEquipo1 = ?, idEquipo2 = ?, puntuacionEquipo1 = ?, puntuacionEquipo2 = ?, ganador = ? WHERE id = ?";
        Object[] params = {partido.getJornada(), partido.getIdEquipo1(), partido.getIdEquipo2(), partido.getPuntuacionEquipo1(), partido.getPuntuacionEquipo2(), partido.getGanador(), partido.getId()};
        ConnectionManager.ejecutarUpdateSQL(sql, params);
        return true;
    }

    public static Partido guardarPartido(Partido partido) {

        String sql = "INSERT INTO partidos (jornada, idEquipo1, idEquipo1, puntuacionEquipo1, puntuacionEquipo2, ganador) VALUES (?, ?, ?, ?, ?, ?)";
        Object[] params = {partido.getJornada(), partido.getIdEquipo1(), partido.getIdEquipo2(), partido.getPuntuacionEquipo1(), partido.getPuntuacionEquipo2(), partido.getGanador()};
        int id = (int) ConnectionManager.ejecutarInsertSQL(sql, params);
        if (id > 0){
            partido.setId(id);
        }
        return partido;
    }

    public static boolean eliminarPartido(int idPartido) {

        String sql = "DELETE FROM partidos WHERE id = ?";
        Object[] params = {idPartido};
        ConnectionManager.ejecutarUpdateSQL(sql,params);
        return true;
    }
}

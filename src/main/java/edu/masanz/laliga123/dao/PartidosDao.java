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
}

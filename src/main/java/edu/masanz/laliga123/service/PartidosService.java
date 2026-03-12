package edu.masanz.laliga123.service;

import edu.masanz.laliga123.dao.PartidosDao;
import edu.masanz.laliga123.model.Partido;

import java.util.List;

public class PartidosService {

    public static List<Partido> obtenerPartidos() {

        return PartidosDao.obtenerPartidos();
    }

    public static Partido obtenerPartido(int idPartido) {

        return PartidosDao.obtenerPartidos(idPartido);
    }

    public static boolean actualizarPartido(Partido partido) {

        return PartidosDao.actualizarPartido(partido);
    }

    public static Partido guardarPartido(Partido partido) {

        return PartidosDao.guardarPartido(partido);
    }

    public static boolean eliminarPartido(int idPartido) {

        return PartidosDao.eliminarPartido(idPartido);
    }
}

package edu.masanz.laliga123.service;

import edu.masanz.laliga123.dao.ITeamDao;
import edu.masanz.laliga123.model.Team;

public class TeamService {



    public static Team obtenerEquipo(int id){
        return ITeamDao.obtenerTeam(id);
    }

    public static Team guardarEquipo(Team team) {
        return ITeamDao.guardarEquipo(team);
    }

    public static Team obtenerTeam(int idTeam) {
        return ITeamDao.obtenerTeam(idTeam);
    }

    public static boolean actualizarTeam(Team team) {
        return false;
    }

    public static boolean eliminarNota(int idTeam) {
        return ITeamDao.eliminarEquipo(idTeam);
    }

    public static Team buscarPorId(int id) {
        return ITeamDao.obtenerTeam(id);
    }
}

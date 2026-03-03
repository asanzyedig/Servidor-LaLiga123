package edu.masanz.laliga123.service;

import edu.masanz.laliga123.dao.ITeamDao;
import edu.masanz.laliga123.model.Team;

public class TeamService {



    public static Team obtenerEquipo(int id){
        return ITeamDao.obtenerTeam(id);
    }
}

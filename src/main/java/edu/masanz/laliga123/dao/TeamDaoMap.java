package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.model.Team;

import java.util.Map;
import java.util.TreeMap;

public class TeamDaoMap {

    private static Map<Long, Team> mapaTeams = new TreeMap<>();

    public Team obtenerTeam(long idTeam) {
        Team team = mapaTeams.get(idTeam);
        if (team == null) {
            team = new Team();
        }
        return team;
    }
}

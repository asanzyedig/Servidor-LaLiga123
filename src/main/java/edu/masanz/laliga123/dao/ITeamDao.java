package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.model.User;

import java.util.ArrayList;
import java.util.List;

public class ITeamDao {

    public static Team obtenerTeam(int id){
        String sql = "select id, name, sede, image from teams where id = ?";
        Object[] params = {id};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length>0) {
            Team team = new Team();
            team.setId((Integer) resultado[0][0]);
            team.setName((String) resultado[0][1]);
            team.setSede((String) resultado[0][2]);
            team.setImage((String) resultado[0][3]);
            return team;
        }
        return null;
    }

    public static List<Team> obtenerTeams() {
        List<Team> teams = new ArrayList<>();

        String sql = "select id, name, sede, image from teams";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);

        if (resultado != null && resultado.length > 0){
            for (int i = 0; i < resultado.length; i++) {
                Team team = new Team();
                team.setId((Integer) resultado[i][0]);
                team.setName((String) resultado[i][1]);
                team.setSede((String) resultado[i][2]);
                team.setImage((String) resultado[i][3]);
                teams.add(team);
            }
        }
        return teams;
    }

    public static Team guardarEquipo(Team team) {
        String sql = "INSERT INTO teams (name, sede, image) VALUES (?, ?, ?)";
        Object[] params = {team.getName(), team.getSede(), team.getImage()};
        int id = (int) ConnectionManager.ejecutarInsertSQL(sql, params);
        System.out.println(id);
        if (id > 0){
            team.setId(id);
        }
        return team;
    }
}

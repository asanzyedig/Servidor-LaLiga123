package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.Team;
import edu.masanz.laliga123.model.User;

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

}

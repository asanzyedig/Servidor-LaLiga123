package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDao {

    public static User login(String username, String password){
        String select = "SELECT * FROM USERS WHERE username = ? AND password = ?";
        Object[] params = {username,password};
        Object[][] result = ConnectionManager.ejecutarSelectSQL(select,params);
        if (result.length == 1) {
            User user = new User();
            int id = (int) result[0][0];
            String usuario = (String) result[0][1];
            String pass = (String) result[0][2];
            int rol = (int)result[0][3];

            user.setId(id);
            user.setUsername(usuario);
            user.setPassword(pass);
            user.setRol(rol);
            return user;
        }
        return null;
    }

    public static List<User> obtenerUsers() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT id, username, password, rol FROM users";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        if (resultado != null && resultado.length>0) {
            for(int i = 0; i < resultado.length; i++) {
                User user = new User();
                user.setId((Integer) resultado[i][0]);
                user.setUsername((String) resultado[i][1]);
                user.setPassword((String) resultado[i][2]);
                user.setRol((Integer) resultado[i][3]);
                users.add(user);
            }
        }
        return users;
    }
}

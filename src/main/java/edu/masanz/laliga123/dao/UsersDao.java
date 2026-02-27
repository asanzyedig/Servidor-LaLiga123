package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.User;

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

            user.setUsername(usuario);
            user.setPassword(pass);
            user.setRol(rol);
            return user;
        }
        return null;
    }

    public static List<User> obtenerUsers() {
        String sql = "SELECT id, username, password, rol FROM users";
        Object[] params = {};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        return null;
    }
}

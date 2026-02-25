package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;
import edu.masanz.laliga123.model.User;

public class UsersDao {

    public static User login(String username, String password){
        String select = "SELECT * FROM USERS where username = ? and password = ?";
        Object[] params = {username,password};
        Object[][] result = ConnectionManager.ejecutarSelectSQL(select,params);
        if (result.length == 1) {
            User user = new User();
            String usuario = (String) result[0][0];
            String pass = (String) result[0][1];
            int rol = (int)result[0][2];

            user.setUsername(usuario);
            user.setPassword(pass);
            user.setRol(rol);
            return user;
        }
                return null;
    }
}

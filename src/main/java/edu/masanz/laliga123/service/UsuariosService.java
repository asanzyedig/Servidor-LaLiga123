package edu.masanz.laliga123.service;

import edu.masanz.laliga123.model.User;

import java.util.Map;

public class UsuariosService {

    private Map<String, User> usuarios = Map.of(
        "admin",new User("admin","admin",1),
        "user",new User("user","1234",2)
    );

    public User autenticar(String username, String password) {
        User user = usuarios.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}

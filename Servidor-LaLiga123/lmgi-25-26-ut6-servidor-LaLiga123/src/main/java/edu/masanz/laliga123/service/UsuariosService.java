package edu.masanz.laliga123.service;

import edu.masanz.laliga123.model.Usuario;

import java.util.Map;

public class UsuariosService {

    private Map<String, Usuario> usuarios = Map.of(
        "admin",new Usuario("admin","admin"),
        "user",new Usuario("user","1234")
    );

    public Usuario autenticar(String username, String password) {
        Usuario user = usuarios.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


}

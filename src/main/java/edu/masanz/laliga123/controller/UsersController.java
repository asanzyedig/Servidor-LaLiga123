package edu.masanz.laliga123.controller;


import edu.masanz.laliga123.dao.UsersDao;
import edu.masanz.laliga123.model.User;
import edu.masanz.laliga123.service.UsersService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersController {

    public static void principal(@NotNull Context context) {

        context.redirect("/login");
    }

    public static void login(Context context) {
        context.render("/templates/login.ftl");
    }

    public static void hacerLogin(@NotNull Context context) {
        String username = context.formParam("username");
        String password = context.formParam("password");

        boolean autenticar = UsersService.autenticar(username, password);

        if (autenticar) {
            context.redirect("/inicio");
        } else {
            context.redirect("/login");
        }
    }

    public static void inicio(@NotNull Context context) {

        context.render("/templates/inicio.ftl");
    }


    public static void listarUsers(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();

        List<User> users = UsersService.obtenerUsers();
        model.put("usuarios", users);

        context.render("/templates/lista-users.ftl", model);
    }

    public static void servirUser(@NotNull Context context) {

        int idUser = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        User user = UsersService.obtenerUser(idUser);
        model.put("eliminar", false);
        model.put("user",user);
        if (user.getId() == 0) {
            model.put("mensajeError", "Usuario no encontrado");
        }
        context.render("/templates/form-user.ftl", model);

    }

    public static void editaUser(@NotNull Context context) {
        int idUser = Integer.parseInt(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        User user = UsersService.obtenerUser(idUser);
        model.put("agregar", false);
        model.put("user", user);
        if (idUser == 0) {
            model.put("mensajeError", "Usuario no encontrado");
        }
        context.render("/templates/form-user.ftl", model);
    }

    public static void editarUser(@NotNull Context context) {
        int idUser = Integer.parseInt(context.pathParam("id"));
        String username = context.formParam("username");
        String password = context.formParam("password");
        int rol = Integer.parseInt(context.formParam("rol"));
        User user = new User(idUser,username,password,rol);
        if (UsersService.actualizarUser(user)) {
            context.redirect("/lista-users");
        }
    }

    public static void addUser(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();
        User user = new User();
        model.put("agregar", true);
        model.put("user",user);
        context.render("/templates/form-user-add.ftl", model);
    }

    public static void crearUser(@NotNull Context context) {
        String username = context.formParam("username");
        String password = context.formParam("password");
        int rol = Integer.parseInt(context.formParam("rol"));
        User user = new User(username,password,rol);
        user = UsersService.guardarUser(user);
        if (user.getId() != 0) {
            context.redirect("/lista-users");
        }
    }

    public static void delUser(@NotNull Context context) {

        int idUser = Integer.parseInt(context.pathParam("id"));
        Map<String,Object> model = new HashMap<>();
        User user = UsersService.obtenerUser(idUser);
        model.put("eliminar", true);
        model.put("user", user);
        if (user.getId() == 0) {
            model.put("mensajeError", "Usuario no encontrado");
        }
        context.render("/templates/user.ftl", model);
    }

    public static void eliminarUser(@NotNull Context context) {
        int idUser = Integer.parseInt(context.pathParam("id"));
        if (UsersService.eliminarUser(idUser)) {
            context.redirect("/lista-users");
        }
    }
}

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

    public static void login(Context context) {
        context.render("/templates/login.ftl");
    }

    public static void hacerLogin(@NotNull Context context) {
        String username = context.pathParam("username");
        String password = context.pathParam("password");
        UsersService.login(username,password);

        context.redirect("/inicio");

    }

    public static void inicio(@NotNull Context context) {

        context.render("/templates/inicio.ftl");
    }


    public static void listarUsers(@NotNull Context context) {
        Map<String, Object> model = new HashMap<>();

        List<User> users = UsersDao.obtenerUsers();
        model.put("usuarios", users);

        context.render("/templates/lista-users.ftl", model);
    }

    public static void editaUser(@NotNull Context context) {
    }

    public static void addUser(@NotNull Context context) {
    }

    public static void delUser(@NotNull Context context) {
    }
}

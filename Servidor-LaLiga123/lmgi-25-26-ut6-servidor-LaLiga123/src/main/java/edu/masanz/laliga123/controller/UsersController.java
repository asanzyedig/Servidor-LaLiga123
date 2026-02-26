package edu.masanz.laliga123.controller;


import edu.masanz.laliga123.service.UsersService;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class UsersController {

    public static void login(Context context) {
        String username = context.pathParam("username");
        String password = context.pathParam("password");
        UsersService.login(username,password);

        context.render("/templates/login.ftl");
    }

    public static void inicio(@NotNull Context context) {

        context.render("/templates/inicio.ftl");
    }
}

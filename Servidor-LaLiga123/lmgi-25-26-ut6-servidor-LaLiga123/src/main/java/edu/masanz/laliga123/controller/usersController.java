package edu.masanz.laliga123.controller;


import io.javalin.http.Context;

public class usersController {

    public static void login(Context context) {
        String username = context.pathParam("username");
        String password = context.pathParam("password");
    }
}

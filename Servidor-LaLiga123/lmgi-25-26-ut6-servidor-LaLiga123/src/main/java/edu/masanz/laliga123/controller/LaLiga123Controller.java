package edu.masanz.laliga123.controller;

import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LaLiga123Controller {


    public static void login(@NotNull Context context) {
        Map<String , Object> model = new HashMap<>();
        context.render("/templates/login.ftl", model);

    }
}

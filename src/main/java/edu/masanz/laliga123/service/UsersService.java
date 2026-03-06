package edu.masanz.laliga123.service;


import edu.masanz.laliga123.dao.UsersDao;
import edu.masanz.laliga123.model.User;

import java.util.List;

public class UsersService {

    public static User login(String username, String password){
        return UsersDao.login(username,password);
    }

    public static List<User> obtenerUsers() {
        return UsersDao.obtenerUsers();
    }

    public static User obtenerUser(int idUser) {
        return UsersDao.obtenerUser(idUser);
    }

    public static boolean actualizarUser(User user) {
        return UsersDao.actualizarUser(user);
    }

    public static User guardarUser(User user) {
        return UsersDao.guardarUser(user);
    }

    public static boolean eliminarUser(int idUser) {
        return UsersDao.eliminarUser(idUser);
    }
}

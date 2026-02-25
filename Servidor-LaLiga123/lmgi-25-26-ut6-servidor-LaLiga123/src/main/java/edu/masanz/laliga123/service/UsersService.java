package edu.masanz.laliga123.service;


import edu.masanz.laliga123.dao.UsersDao;
import edu.masanz.laliga123.model.User;

public class UsersService {

    public static User login(String username, String password){
        return UsersDao.login(username,password);
    }
}

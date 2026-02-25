package edu.masanz.laliga123.dao;

import edu.masanz.laliga123.database.ConnectionManager;

public class LaLiga123DaoDb {

    public LaLiga123DaoDb() {

        ConnectionManager.conectar("LaLiga123","admin","admin");
    }
}

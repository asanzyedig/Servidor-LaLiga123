package edu.masanz.laliga123.model;

public class Team {
    private int id;
    private String name;
    private String sede;
    private String image;

    public Team(String name, String sede) {
        this.name = name;
        this.sede = sede;
    }

    public Team() {
    }

    public Team(int idTeam, String nombre, String sede) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sede='" + sede + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}

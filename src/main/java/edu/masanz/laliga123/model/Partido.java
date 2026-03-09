package edu.masanz.laliga123.model;

public class Partido {

    private int id;
    private int jornada;
    private int idEquipo1;
    private int idEquipo2;
    private int puntuacionEquipo1;
    private int puntuacionEquipo2;
    private int ganador;

    public Partido() {this(0,0,0,0,0,0);}


    public Partido(int jornada, int idEquipo1, int idEquipo2, int puntuacionEquipo1, int puntuacionEquipo2, int ganador) {
        this.jornada = jornada;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.puntuacionEquipo1 = puntuacionEquipo1;
        this.puntuacionEquipo2 = puntuacionEquipo2;
        this.ganador = ganador;
    }

    public Partido(int id, int jornada, int idEquipo1, int idEquipo2, int puntuacionEquipo1, int puntuacionEquipo2, int ganador) {
        this.id = id;
        this.jornada = jornada;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.puntuacionEquipo1 = puntuacionEquipo1;
        this.puntuacionEquipo2 = puntuacionEquipo2;
        this.ganador = ganador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(int idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(int idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    public int getPuntuacionEquipo1() {
        return puntuacionEquipo1;
    }

    public void setPuntuacionEquipo1(int puntuacionEquipo1) {
        this.puntuacionEquipo1 = puntuacionEquipo1;
    }

    public int getPuntuacionEquipo2() {
        return puntuacionEquipo2;
    }

    public void setPuntuacionEquipo2(int puntuacionEquipo2) {
        this.puntuacionEquipo2 = puntuacionEquipo2;
    }

    public int getGanador() {
        return ganador;
    }

    public void setGanador(int ganador) {
        this.ganador = ganador;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", jornada=" + jornada +
                ", idEquipo1=" + idEquipo1 +
                ", idEquipo2=" + idEquipo2 +
                ", puntuacionEquipo1=" + puntuacionEquipo1 +
                ", puntuacionEquipo2=" + puntuacionEquipo2 +
                ", ganador=" + ganador +
                '}';
    }
}

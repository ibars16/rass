package com.example.tasca2;

public class Incidencia {

    private String id_incidencia;
    private String nombre;


    public Incidencia(String id_incidencia, String nombre) {
        this.id_incidencia = id_incidencia;
        this.nombre = nombre;
    }

    public String getId_incidencia() {
        return id_incidencia;
    }

    public void setId_incidencia(String id_incidencia) {
        this.id_incidencia = id_incidencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Incidencia{" +
                "id_incidencia='" + id_incidencia + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

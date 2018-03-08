package com.projectApp.JuanCristobalJavier.applaescalera.model;

/**
 * Created by 21639999 on 26/02/2018.
 */

public class Demanda {
    String nombre;
    String des;
    boolean disponible;
    String nombreUsuario;

    public Demanda(String nombre, String des, boolean disponible, String nombreUsuario) {
        this.nombre = nombre;
        this.des = des;
        this.disponible = disponible;
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDes() {
        return des;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}

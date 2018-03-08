package com.projectApp.JuanCristobalJavier.applaescalera.model;

/**
 * Created by 21639999 on 26/02/2018.
 */

public class Usuario {

    String nombre;
    String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmeil(String email) {
        email = email;
    }
}

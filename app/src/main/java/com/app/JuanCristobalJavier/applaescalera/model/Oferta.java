package com.app.JuanCristobalJavier.applaescalera.model;

/**
 * Created by 21639999 on 26/02/2018.
 */

public class Oferta {

    String nombre;
    String des;
    String nombreUsuario;
    String email;

    public Oferta(String nombre, String des, String nombreUsuario, String email) {
        this.nombre = nombre;
        this.des = des;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
    }

    public Oferta() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDes() {
        return des;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

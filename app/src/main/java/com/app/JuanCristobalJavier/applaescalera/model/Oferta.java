package com.app.JuanCristobalJavier.applaescalera.model;

/**
 * Created by 21639999 on 26/02/2018.
 */

public class Oferta {

    String nombre;
    String des;
    String nombreUsuario;

    public Oferta(String nombre, String des, String nombreUsuario) {
        this.nombre = nombre;
        this.des = des;
        this.nombreUsuario = nombreUsuario;
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
}

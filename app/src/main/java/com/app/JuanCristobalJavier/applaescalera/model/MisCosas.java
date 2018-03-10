package com.app.JuanCristobalJavier.applaescalera.model;

import android.widget.ImageView;

/**
 * Created by cristobal on 08/03/2018.
 */

public class MisCosas {

    String nombre;
    String descripcion;
    int imagen;

    public MisCosas(String nombre, String descripcion, int imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

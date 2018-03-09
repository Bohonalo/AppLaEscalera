package com.app.JuanCristobalJavier.applaescalera.model;

/**
 * Created by cristobal on 08/03/2018.
 */

public class Chat {

    private String mensaje;
    private String usuario;
    private int imagen;


    public Chat(String usuario,String mensaje, int imagen) {
        this.mensaje = mensaje;
        this.usuario = usuario;
        this.imagen = imagen;
    }


    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

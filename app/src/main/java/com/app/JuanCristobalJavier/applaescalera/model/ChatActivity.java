package com.app.JuanCristobalJavier.applaescalera.model;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


import com.app.JuanCristobalJavier.applaescalera.R;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.AdaptadorChat;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager miLinearLayout;
    private ArrayList <Chat> lista;
    TextView titulo;
    TextView texto;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        rv = findViewById(R.id.idRVchat);
        rv.setHasFixedSize(true);
        miLinearLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(miLinearLayout);

        imagen = findViewById(R.id.idImagenChat);
        titulo = findViewById(R.id.idTituloChat);
        texto = findViewById(R.id.idTextoChat);

        lista = new ArrayList<Chat>();

        AdaptadorChat adap = new AdaptadorChat(this,R.layout.item_chat, lista);
        rv.setAdapter(adap);

        cargarDatos();
    }

    private void cargarDatos() {
        Chat c1 = new Chat("Juan Sanchez", "Pablo qué tal, estoy buscando un taladro para el fin de semana...", R.drawable.hombre1);
        Chat c2 = new Chat("Irene Ruiz", "Hola Pablete cómo estas hoy..., necesito que pasees a Laika. Ya me dices luego guapo", R.drawable.mujer1);
        Chat c3 = new Chat("Esperanza Sanz", "Pablo chatin, que no contestas a mis mensajes...", R.drawable.mujer2);
        Chat c4 = new Chat("Ana Perez", "Buenos días, el taladro que Usted me dejó estaba roto, la cosa del centro (me parece que se llama broca) daba vueltas muy deprisa", R.drawable.mujer3);
        Chat c5 = new Chat("Arturo y Luisa", "Hola!! buscamos alguien para compartir gastos con la conexión de internet", R.drawable.pareja);
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
        lista.add(c5);
    }
}

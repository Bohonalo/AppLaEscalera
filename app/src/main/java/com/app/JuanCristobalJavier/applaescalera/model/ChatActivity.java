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
    private ArrayList lista;
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
        Chat c1 = new Chat("Iñigo Errejon", "Pablo qué tal, estoy buscando un taladro, pero debe ser morado", R.drawable.errejon);
        Chat c2 = new Chat("Irene Montero", "Hola Pablete cómo estas hoy..., necesito que pasees a mi perrita. Ya me dices luego guapo", R.drawable.irene);
        Chat c3 = new Chat("Esperanza Aguirre", "Pablo chatin, que no contestas a mis mensajes...", R.drawable.esperanza);
        Chat c4 = new Chat("Irene Arrimadas", "Buenos días, el taladro que Usted me dejó estaba roto, la cosa del centro (me parece que se llama broca) daba vueltas muy deprisa", R.drawable.ines);

        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        lista.add(c4);
    }
}

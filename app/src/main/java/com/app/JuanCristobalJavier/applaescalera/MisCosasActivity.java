package com.app.JuanCristobalJavier.applaescalera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.model.MisCosas;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.Adaptador;

import java.util.ArrayList;

public class MisCosasActivity extends AppCompatActivity {

    private RecyclerView rv;
    private LinearLayoutManager miLinearLayout;
    private ArrayList lista;
    TextView titulo;
    TextView texto;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_cosas);

        rv = findViewById(R.id.idRVmisCosas);
        rv.setHasFixedSize(true);
        miLinearLayout = new LinearLayoutManager(this);
        rv.setLayoutManager(miLinearLayout);

        imagen = findViewById(R.id.idImagen);
        titulo = findViewById(R.id.idTitulo);
        texto = findViewById(R.id.idTexto);

        lista = new ArrayList<MisCosas>();

        Adaptador adap = new Adaptador(this,R.layout.item_miscosas, lista);
        rv.setAdapter(adap);

        cargarDatos();
    }

    private void cargarDatos() {
        MisCosas d1 = new MisCosas("Comparto Coche", "Bajo a Madrid de Lunea a Viernes a las 7" +
                " y vuelvo a las 5. Zona metro Begoña", R.drawable.coche);
        MisCosas d2 = new MisCosas("Comparto Taladro", "Talabro 600W", R.drawable.taladro);
        MisCosas d3 = new MisCosas("Paseo Perro", "Puedo sacar tu perro a las 7 de la mañana...", R.drawable.perro);
        MisCosas d4 = new MisCosas("Impresora", "Hola, apenas uso la impresora y es una pena. Si necesitas imprimir algo, estoy disponible.", R.drawable.impresora);
        MisCosas d5 = new MisCosas("Senderismo", "Me gusta pasear y hacer senderismo por la montaña. Suelo salir a la pedriza todos los Domingos.",  R.drawable.paseo);
        MisCosas d6 = new MisCosas("Un buen café", "Hola, tengo la mayoria de las tardes libres y a veces pienso que es una pena no compartir una buena taza de café. ", R.drawable.cafe);
        MisCosas d7 = new MisCosas("Busco canguro", "Hola soy Carolina, busco alguien de confianza en el barrio/urbanización que cuide de mi bebe.", R.drawable.mujer3);


        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        lista.add(d6);
        lista.add(d7);

    }
}

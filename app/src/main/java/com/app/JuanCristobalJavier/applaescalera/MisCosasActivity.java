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
        lista.add(d1);
        lista.add(d2);
        lista.add(d3);



    }
}

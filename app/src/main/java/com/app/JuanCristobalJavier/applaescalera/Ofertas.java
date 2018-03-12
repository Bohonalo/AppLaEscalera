package com.app.JuanCristobalJavier.applaescalera;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.model.Oferta;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.AdaptadorOD;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ofertas extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList <Oferta> lista;
    private AdaptadorOD adaptador;
    TextView nombreUsuario;
    TextView nombreProducto;
    ImageView deescrip;


    public Ofertas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ofertas, container, false);
        lista = new ArrayList<Oferta>();
        recyclerView = v.findViewById(R.id.rvOfertas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cargarDatos();

        AdaptadorOD adapter = new AdaptadorOD(lista);
        recyclerView.setAdapter(adapter);
        //configurarRV();


        return  v;
    }



    private void invocarWS() {


    }

   /* public void configurarRV(){
        recyclerView.setHasFixedSize(true);

        //linearLayoutManager = new LinearLayoutManager(this);
        // recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(Oferta.class, 2);
        recyclerView.setLayoutManager(layoutManager);


        //addOnClickListener();
        adaptador = new AdaptadorOD(lista);
        recyclerView.setAdapter(adaptador);
    }*/

    /*private void addOnClickListener() {
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Seleccionada la opción "
                        + recyclerView.indexOfChild(v)
                        + " con el valor "
                        + ((AdaptadorOD.VhOferta)recyclerView.getChildViewHolder(v));

                Oferta o = lista.get(recyclerView.getChildAdapterPosition(v));

                Intent intent = new Intent(ListaPeliculasActivity.this, PeliculaActivity.class);
                intent.putExtra("id", p.getId());
                startActivity(intent);
            }
        });
    }*/

    private void cargarDatos() {
        Oferta d1 = new Oferta("Comparto Coche", "Bajo a Madrid de Lunea a Viernes a las 7" +
                " y vuelvo a las 5. Zona metro Begoña", "PEPe", "Email");
        Oferta d2 = new Oferta("Comparto Taladro", "Talabro 600W", "PEPe", "Email");
        Oferta d3 = new Oferta("Paseo Perro", "Puedo sacar tu perro a las 7 de la mañana...", "PEPe", "Email");
        Oferta d4 = new Oferta("Impresora", "Hola, apenas uso la impresora y es una pena. Si necesitas imprimir algo, estoy disponible.", "PEPe", "Email");
        Oferta d5 = new Oferta("Senderismo", "Me gusta pasear y hacer senderismo por la montaña. Suelo salir a la pedriza todos los Domingos.",  "PEPe", "Email");
        Oferta d6 = new Oferta("Un buen café", "Hola, tengo la mayoria de las tardes libres y a veces pienso que es una pena no compartir una buena taza de café. ", "PEPe", "Email");
        Oferta d7 = new Oferta("Busco canguro", "Hola soy Carolina, busco alguien de confianza en el barrio/urbanización que cuide de mi bebe.", "PEPe", "Email");
        Oferta d8 = new Oferta("¿Alguien para cuidar mis peces?", "Soy la vecina del atico del portal 2, estoy buscando una persona que pueda echar de comer a mis peces en periodo vacacional", "PEPe", "Email");


        lista.add(d1);
        lista.add(d2);
        lista.add(d3);
        lista.add(d4);
        lista.add(d5);
        lista.add(d6);
        lista.add(d7);
        lista.add(d8);

    }

}

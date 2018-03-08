package com.projectApp.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectApp.JuanCristobalJavier.applaescalera.model.MisCosas;
import com.projectApp.JuanCristobalJavier.applaescalera.recyclerViewUtils.Adaptador;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EscaleraFragment extends Fragment {


    private RecyclerView rv;
    private LinearLayoutManager miLinearLayout;
    private ArrayList lista;
    TextView titulo;
    TextView texto;
    ImageView imagen;

    public EscaleraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_escalera, container, false);
        // Inflate the layout for this fragment
        rv = (RecyclerView)view.findViewById(R.id.idRVmisCosas);
        rv.setHasFixedSize(true);
        miLinearLayout = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(miLinearLayout);

        imagen = (ImageView)view.findViewById(R.id.idImagen);
        titulo = (TextView)view.findViewById(R.id.idTitulo);
        texto = (TextView)view.findViewById(R.id.idTexto);

        lista = new ArrayList<MisCosas>();

        Adaptador adap = new Adaptador(lista);
        rv.setAdapter(adap);

        cargarDatos();
        return view;
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

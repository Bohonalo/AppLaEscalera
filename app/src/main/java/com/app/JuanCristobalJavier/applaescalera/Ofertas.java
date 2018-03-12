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
import com.app.JuanCristobalJavier.applaescalera.model.Usuario;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.AdaptadorOD;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ofertas extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList <Oferta> lista;
    private AdaptadorOD adaptador;
    private DatabaseReference dr;
    private FirebaseDatabase fr;
    private Oferta o;



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
        fr = FirebaseDatabase.getInstance();
        o = new Oferta();

        cargarDatos();

        AdaptadorOD adapter = new AdaptadorOD(lista);
        recyclerView.setAdapter(adapter);
        //configurarRV();


        return  v;
    }



    private void invocarWS() {


    }


    private void cargarDatos() {
        dr = fr.getReference("ObjetosOferta");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    o = dataSnapshot1.getValue(Oferta.class);
                    lista.add(o);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}

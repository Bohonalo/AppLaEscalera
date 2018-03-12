package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.app.JuanCristobalJavier.applaescalera.model.Demanda;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.AdaptadorDemandas;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Demandas extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList <Demanda> lista;
    private AdaptadorDemandas adapter;
    private DatabaseReference dr;
    private FirebaseDatabase fr;
    private Demanda d;

    public Demandas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demandas, container, false);


        lista = new ArrayList<>();
        recyclerView = v.findViewById(R.id.rvDemandas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fr = FirebaseDatabase.getInstance();
        d = new Demanda();

        cargarDatos();

        return  v;
    }


    private void cargarDatos() {
        dr = fr.getReference("ObjetosDemanda");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    d = dataSnapshot1.getValue(Demanda.class);
                    lista.add(d);
                }
                adapter = new AdaptadorDemandas(lista);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}

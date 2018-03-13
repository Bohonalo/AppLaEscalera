package com.app.JuanCristobalJavier.applaescalera;



import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.JuanCristobalJavier.applaescalera.model.Oferta;
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
    private ArrayList <Oferta> lista, newList;
    private AdaptadorOD adapter;
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
        lista = new ArrayList<>();
        newList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.rvOfertas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fr = FirebaseDatabase.getInstance();
        o = new Oferta();

        cargarDatos();

        return  v;
    }


    private void cargarDatos() {
        dr = fr.getReference("ObjetosOferta");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista.clear();
                newList.clear();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    o = dataSnapshot1.getValue(Oferta.class);
                    lista.add(o);
                }
                int size = lista.size()-1;

                for(int i=size;i>=0;i--){
                    newList.add(lista.get(i));
                }

                adapter = new AdaptadorOD(newList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}

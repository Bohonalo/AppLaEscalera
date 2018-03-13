package com.app.JuanCristobalJavier.applaescalera;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.model.Demanda;
import com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils.AdaptadorDemandas;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    private ArrayList <Demanda> lista, newList;
    private AdaptadorDemandas adapter;
    private DatabaseReference dr;
    private FirebaseDatabase fr;
    private Demanda d;

    private TextView emailItem;
    private String correo;


    public Demandas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_demandas, container, false);


        lista = new ArrayList<>();
        newList = new ArrayList<>();
        recyclerView = v.findViewById(R.id.rvDemandas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fr = FirebaseDatabase.getInstance();
        emailItem = v.findViewById(R.id.idCorreoItem);
        correo = obterEmail();
        d = new Demanda();

        cargarDatos();


        return  v;
    }



    /*public void enviarCorreo(View v){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",
                correo, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Android APP - ");
        startActivity(emailIntent);
    }*/


    private String obterEmail() {
        String email = "";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
        }
        return email;
    }


    private void cargarDatos() {
        dr = fr.getReference("ObjetosDemanda");
        dr.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista.clear();
                newList.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    d = dataSnapshot1.getValue(Demanda.class);
                    lista.add(d);
                }
                int size = lista.size()-1;

                for(int i=size;i>=0;i--){
                    newList.add(lista.get(i));
                }

                adapter = new AdaptadorDemandas(newList);
                recyclerView.setAdapter(adapter);


                adapter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Demanda de = newList.get(recyclerView.getChildAdapterPosition(v));
                        Intent i = new Intent(Intent.ACTION_SEND); i.setType("text/plain");
                        i.putExtra(Intent.EXTRA_EMAIL , de.getEmail());
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}

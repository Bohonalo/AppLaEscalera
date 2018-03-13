package com.app.JuanCristobalJavier.applaescalera;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.JuanCristobalJavier.applaescalera.model.Oferta;
import com.app.JuanCristobalJavier.applaescalera.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuardarDemanda extends Fragment {

    private EditText nombre;
    private EditText descrip;
    private Button btnGuardar, btnAtras;
    private Usuario u;
    private String email;
    private FirebaseDatabase fr;
    private String nombreU;
    private DatabaseReference dr;


    public GuardarDemanda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_guardar_demanda, container, false);

        fr = FirebaseDatabase.getInstance();

        nombre = v.findViewById(R.id.edtNombreDemanda);
        descrip = v.findViewById(R.id.edtDescripDemanda);
        btnGuardar = v.findViewById(R.id.btnGuardarDemanda);
        btnAtras = v.findViewById(R.id.btnAtrasD);
        u = new Usuario();

        email = obterEmail();

        obterNombre();

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guardarObjetoRealtime(email, nombreU);
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Principal.class);
                getActivity().startActivity(i);

            }
        });

        return v;
    }


    private void obterNombre() {
        dr = fr.getReference("Usuarios");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    u = dataSnapshot1.getValue(Usuario.class);
                    System.out.print(u.getNombre());
                    if (u.getEmail().equalsIgnoreCase(email)) {
                        nombreU = u.getNombre();
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private String obterEmail() {
        String email = "";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
        }
        return email;
    }

    private void guardarObjetoRealtime(String emailP, String nombrePer) {
        dr = FirebaseDatabase.getInstance().getReference().child("ObjetosDemanda");

        String descripO = descrip.getText().toString();
        String nombreP = nombre.getText().toString();

        Oferta o = new Oferta(nombreP, descripO, nombrePer, emailP);
        dr.push().setValue(o);

        Intent i = new Intent(getActivity(), Principal.class);
        getActivity().startActivity(i);

//        ContenedorFragment nuevoFragmento = new ContenedorFragment();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.frament, nuevoFragmento);
//        transaction.addToBackStack(null);
//
//        // Commit a la transacción
//        transaction.commit();
    }
}
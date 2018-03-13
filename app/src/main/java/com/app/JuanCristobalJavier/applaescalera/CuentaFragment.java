package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class CuentaFragment extends Fragment {


    private FirebaseDatabase fr;
    private DatabaseReference dr;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    private String email;

    private TextView nombreUsuario;
    private Usuario usuario;
    private String user;

    public CuentaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_cuenta, container, false);

        fr = FirebaseDatabase.getInstance();


        nombreUsuario = v.findViewById(R.id.idMiUsuario);
        usuario = new Usuario();
        email = obterEmail();
        obterNombre();
        return v;
    }


    private void obterNombre() {
        dr = fr.getReference("Usuarios");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    usuario = dataSnapshot1.getValue(Usuario.class);
                    if (usuario.getEmail().equalsIgnoreCase(email)) {
                        user = usuario.getNombre();
                        nombreUsuario.setText(user);
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


}

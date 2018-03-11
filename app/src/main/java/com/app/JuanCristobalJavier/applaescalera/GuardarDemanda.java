package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuardarDemanda extends Fragment {

    private FirebaseFirestore db;
    private EditText nombre;
    private EditText descrip;
    private Button btnGuardar;


    public GuardarDemanda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_guardar_demanda, container, false);

        db = FirebaseFirestore.getInstance();
        nombre = v.findViewById(R.id.edtNombreDemanda);
        descrip = v.findViewById(R.id.edtDescripDemanda);
        btnGuardar = v.findViewById(R.id.btnGuardarDemanda);

        btnGuardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {



            }
        });

        return v;
    }

}

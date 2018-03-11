package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.JuanCristobalJavier.applaescalera.model.Oferta;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuardarOferta extends Fragment {
    private FirebaseFirestore db;
    private EditText nombre;
    private EditText descrip;
    private EditText nombreP;
    private Button btnGuardar;
    private DatabaseReference mDatabaseReference;

    public GuardarOferta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_guardar_oferta, container, false);

        db = FirebaseFirestore.getInstance();
        nombre = v.findViewById(R.id.edtNombreOferta);
        descrip = v.findViewById(R.id.edtDescripOferta);
        btnGuardar = v.findViewById(R.id.btnGuardarOferta);
        nombreP = v.findViewById(R.id.edtNombrePersonaOferta);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                guardarObjetoRealtime();
            }
        });

        return v;
    }

    private void guardarObjetoRealtime() {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ObjetosOferta");

        String nombreO = nombre.getText().toString();
        String descripO = descrip.getText().toString();
        String nombrePer = nombreP.getText().toString();

        Oferta o = new Oferta(nombreO, descripO, nombrePer);
        mDatabaseReference.push().setValue(o);

        ContenedorFragment nuevoFragmento = new ContenedorFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frament, nuevoFragmento);
        transaction.addToBackStack(null);

        // Commit a la transacción
        transaction.commit();
    }

    private void guardarObjetosCloud() {
        String nombreO = nombre.getText().toString();
        String descripO = descrip.getText().toString();
        String nombrePer = nombreP.getText().toString();

        // Create a new user with a first and last name
        Map<String, Object> ObjetosOfera = new HashMap<>();


        ObjetosOfera.put("NombrePersona", nombrePer);
        ObjetosOfera.put("NombreObjeto", nombreO);
        ObjetosOfera.put("Descripcion", descripO);

        // Add a new document with a generated ID
        db.collection("objetosOfeta")
                .add(ObjetosOfera)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(),"DocumentSnapshot added with ID: " + documentReference.getId(), Toast.LENGTH_LONG).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(),"Error adding document", Toast.LENGTH_LONG).show();
                    }
                });
    }


    private void obtenerNombre() {

        db.collection("Usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Map<String, Object> documento = document.getData();

                                String nombreP = (String) documento.get("Nombre");

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error getting documents.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}

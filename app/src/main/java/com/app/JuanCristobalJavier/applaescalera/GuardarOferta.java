package com.app.JuanCristobalJavier.applaescalera;


import android.net.Uri;
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
import com.app.JuanCristobalJavier.applaescalera.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    private Button btnGuardar;
    private DatabaseReference mDatabaseReference;
    private Usuario u;
    private String nombreU;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

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
        u = new Usuario();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =  firebaseDatabase.getReference("Usuarios");

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = obterEmail();

                String nombrePersona = obterNombre(email);

                guardarObjetoRealtime(email, nombrePersona);

            }
        });

        return v;
    }

    private String obterNombre(final String email) {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    u = dataSnapshot1.getValue(Usuario.class);
                    System.out.print(u.getNombre());
/*                    if (u.getEmail().equalsIgnoreCase(email)){
                       nombreU =  u.getNombre();
                    }*/
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return nombreU;
    }

    private String obterEmail() {
        String email = "";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            email = user.getEmail();
        }
        return  email;
    }

    private void guardarObjetoRealtime(String emailP, String nombrePer) {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("ObjetosOferta");

        String descripO = descrip.getText().toString();
        String nombreP = nombre.getText().toString();

        Oferta o = new Oferta(nombreP, descripO, nombrePer, emailP);
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

        // Create a new user with a first and last name
        Map<String, Object> ObjetosOfera = new HashMap<>();


        //ObjetosOfera.put("NombrePersona", nombrePer);
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

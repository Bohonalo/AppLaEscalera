package com.app.JuanCristobalJavier.applaescalera;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.JuanCristobalJavier.applaescalera.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {

    private EditText inputEmail, inputNombre, inputPassword;     //hit option + enter if you on mac , for windows hit ctrl + enter
    private Button btnSignIn, btnSignUp;
    private FirebaseAuth auth;
    private DatabaseReference mDatabaseReference;
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.sign_in_button);
        btnSignUp = findViewById(R.id.sign_up_button);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        inputNombre = findViewById(R.id.nombre);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("Usuarios");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String nombre = inputNombre.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.
                            campoEmailVacio), Toast.LENGTH_LONG).show();
                    return;
                }

                if(!validaEmail(email)){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.
                            campoMailInvalido), Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(nombre)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.campoNombreInvalido), Toast.LENGTH_LONG).show();
                    return;
                }
                if(nombre.length() < 10){
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.campoNombreApellidos), Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.
                            campoPasswordInvalido), Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.
                            minimum_password), Toast.LENGTH_LONG).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignupActivity.this,
                                        getResources().getString(R.string.toastUsuarioRegistrado)
                                                + task.isSuccessful(), Toast.LENGTH_LONG).show();

                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this,
                                            getResources().getString(R.string.toastErrorCreacionUsuario)
                                                    + task.isSuccessful(), Toast.LENGTH_LONG).show();
                                } else {
                                    String email = inputEmail.getText().toString().trim();
                                    String nombre = inputNombre.getText().toString().trim();

                                    usuario = new Usuario(nombre, email);
                                    //introducirUsuarioCouldFirestore();
                                    mDatabaseReference.push().setValue(usuario);
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });

    }



    public static Boolean validaEmail (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}

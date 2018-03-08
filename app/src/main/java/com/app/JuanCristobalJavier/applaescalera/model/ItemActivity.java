package com.app.JuanCristobalJavier.applaescalera.model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.MainActivity;
import com.app.JuanCristobalJavier.applaescalera.R;

public class ItemActivity extends AppCompatActivity {

    TextView nombre, descrip;
    String nomb, desc;
    int im;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        /*nombre = findViewById(R.id.txItemNombre);
        descrip = findViewById(R.id.idTxDescrip);


        nomb = getIntent().getStringExtra("nombre");
        desc = getIntent().getStringExtra("texto");

        nombre.setText(nomb);
        descrip.setText(desc);*/
        btnVolver = findViewById(R.id.idBtnVolver);
    }

    public  void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

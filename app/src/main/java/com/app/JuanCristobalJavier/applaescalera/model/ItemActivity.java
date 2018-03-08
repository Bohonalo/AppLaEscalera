package com.app.JuanCristobalJavier.applaescalera.model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.R;

public class ItemActivity extends AppCompatActivity {

    TextView nombre, descrip;
    String nomb, desc;
    int im;

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
    }
}

package com.app.a21639999.applaescalera;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Javier Pérez Juan Raúl Simón Cristóbal Revelles
 */
public class SplashScreen extends AppCompatActivity {

    TextView titulo;
    TextView titulo1;
    TextView welcome;
    ImageView imagenAguacate;
    RelativeLayout r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imagenAguacate = findViewById(R.id.idAguacate);
        r = findViewById(R.id.idGlobal);

        titulo = findViewById(R.id.idTittleSplash);
        titulo1 = findViewById(R.id.idTittleSplash2);
        welcome = findViewById(R.id.idWelcome);

        Typeface fuenteTitulo = Typeface.createFromAsset(getAssets(), "CaviarDreams.ttf");
        titulo.setTypeface(fuenteTitulo);
        titulo.setTextSize(56);

        Typeface fuenteTitulo1 = Typeface.createFromAsset(getAssets(), "CaviarDreams.ttf");
        titulo1.setTypeface(fuenteTitulo1);
        titulo1.setTextSize(56);



        //Typeface fuenteWelcome = Typeface.createFromAsset(getAssets(), "RifficFree-Bold.ttf");
       // welcome.setTypeface(fuenteWelcome);
        welcome.setTextSize(30);


        openApp(true);

        Animation traslateTitulo = AnimationUtils.loadAnimation(this, R.anim.animationtitulo);
        titulo.startAnimation(traslateTitulo);


        Animation rotateImagen = AnimationUtils.loadAnimation(this, R.anim.animationlogo);
        imagenAguacate.startAnimation(rotateImagen);



        Animation e = AnimationUtils.loadAnimation(this, R.anim.animacion_e);
        titulo1.startAnimation(e);



        Animation welcomeI = AnimationUtils.loadAnimation(this, R.anim.animacion_welcome);
        welcome.startAnimation(welcomeI);


        Animation globalP = AnimationUtils.loadAnimation(this, R.anim.animacion_portada);
        r.startAnimation(globalP);

    }


    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}

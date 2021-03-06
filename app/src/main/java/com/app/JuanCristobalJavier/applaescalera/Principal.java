package com.app.JuanCristobalJavier.applaescalera;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.app.JuanCristobalJavier.applaescalera.model.ChatActivity;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        ContenedorFragment.OnFragmentInteractionListener {
    private FirebaseAuth auth;
    public FloatingActionMenu actionMenu;

   // private ViewPager vpPrincipal;

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ViewPagerAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cargarContenido(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.frament, new ContenedorFragment()).commit();
        actionMenu.setVisibility(View.VISIBLE);


    }

    private void cargarContenido(Toolbar toolbar) {
        actionMenu = findViewById(R.id.floatinMenu);
        actionMenu.setClosedOnTouchOutside(true);
        actionMenu.setVisibility(View.INVISIBLE);

        auth = FirebaseAuth.getInstance();


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //vpPrincipal = findViewById(R.id.vpPrincipal);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Principal) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frament, new ContenedorFragment()).commit();
            actionMenu.setVisibility(View.VISIBLE);
        }
         else if (id == R.id.nav_cuenta) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frament, new CuentaFragment()).commit();
            actionMenu.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_terminos) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frament, new TerminosFragment()).commit();
            actionMenu.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_ayuda) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frament, new AyudaFragment()).commit();
            actionMenu.setVisibility(View.INVISIBLE);
        } else if (id == R.id.nav_logout){
            signOut();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void signOut() {
        auth.signOut();

        startActivity(new Intent(Principal.this, LoginActivity.class));
        finish();

// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(Principal.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }

    public void guardarOferta(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frament, new GuardarOferta()).commit();
        actionMenu.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void guardarDemanda(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frament, new GuardarDemanda()).commit();
        actionMenu.setVisibility(View.INVISIBLE);
    }
}

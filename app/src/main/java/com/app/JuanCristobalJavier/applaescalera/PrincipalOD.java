package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalOD extends Fragment  {

    private TabLayout tabs;
    private ViewPager vpPrincipal;
    private NavigationView navigationView;
    private ViewPagerAdapter adapter;

    public PrincipalOD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_principal_od, container, false);
        return v;
    }

   /*private void iniciarNavigationView(View v) {
        navigationView = v.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) PrincipalOD.this);

        tabs = v.findViewById(R.id.tabs);
        vpPrincipal = v.findViewById(R.id.vpPrincipal);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Ofertas(), "Ofertas");
        adapter.addFragment(new Demandas(), "Demandas");
        vpPrincipal.setAdapter(adapter);

        tabs.setupWithViewPager(vpPrincipal);
    }*/

}

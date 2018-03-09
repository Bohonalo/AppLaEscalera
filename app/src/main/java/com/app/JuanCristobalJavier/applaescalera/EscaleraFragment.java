package com.app.JuanCristobalJavier.applaescalera;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.model.MisCosas;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EscaleraFragment extends Fragment {


    private RecyclerView rv;
    private LinearLayoutManager miLinearLayout;
    private ArrayList lista = new ArrayList<MisCosas>();
    TextView titulo;
    TextView texto;

    public EscaleraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_escalera, container, false);


    }

}

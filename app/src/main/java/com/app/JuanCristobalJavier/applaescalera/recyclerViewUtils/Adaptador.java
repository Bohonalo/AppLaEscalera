package com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.EscaleraFragment;
import com.app.JuanCristobalJavier.applaescalera.MisCosasActivity;
import com.app.JuanCristobalJavier.applaescalera.R;
import com.app.JuanCristobalJavier.applaescalera.model.MisCosas;

import java.util.ArrayList;

/**
 * Created by cristobal on 08/03/2018.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.MiViewHolder> implements View.OnClickListener{

        private ArrayList<MisCosas> misCosas;
        private View.OnClickListener listener;


        //¿Dónde se inicializa el arrayList?
    public Adaptador(MisCosasActivity dietaSemanalActivity, int item_dieta, ArrayList<MisCosas> misCosas) {
            this.misCosas = misCosas;
        }

    public Adaptador(ArrayList lista) {
        this.misCosas = lista;
    }


    public static class MiViewHolder extends RecyclerView.ViewHolder {
            private ImageView imagen;
            private TextView textoSup;
            private TextView textoInf;


            public ImageView getImagen() {
                return imagen;
            }

            public TextView getTextoSup() {
                return textoSup;
            }

            public TextView getTextoInf() {
                return textoInf;
            }

            public MiViewHolder(View view) {
                super(view);
                imagen = (ImageView) view.findViewById(R.id.idImagen);
                textoSup = (TextView) view.findViewById(R.id.idTitulo);
                textoInf = (TextView) view.findViewById(R.id.idTexto);
            }
        }
        @Override
        public Adaptador.MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_miscosas, parent, false);
            v.setOnClickListener(this);
            MiViewHolder vh = new MiViewHolder(v);
            return vh;
        }

    public void onBindViewHolder(MiViewHolder holder, int position) {
        holder.imagen.setImageResource(misCosas.get(position).getImagen());
        holder.textoSup.setText(misCosas.get(position).getNombre());
        holder.textoInf.setText(misCosas.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return misCosas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}




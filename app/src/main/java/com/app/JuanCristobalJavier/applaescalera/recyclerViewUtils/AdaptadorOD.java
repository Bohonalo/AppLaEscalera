package com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.R;
import com.app.JuanCristobalJavier.applaescalera.model.Oferta;

import java.util.ArrayList;


/**
 * Created by Juan on 10/03/2018.
 */

public class AdaptadorOD extends RecyclerView.Adapter <AdaptadorOD.VhOferta> implements View.OnClickListener{

    private View.OnClickListener listener;
    private ArrayList<Oferta> lista;

    public AdaptadorOD(ArrayList<Oferta> lista) {
        this.lista = lista;
    }

    @Override
    public VhOferta onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ofertas, parent, false);
        v.setOnClickListener(this);
        VhOferta vh = new VhOferta(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(VhOferta holder, int position) {
        holder.nombrePersona.setText(lista.get(position).getNombreUsuario());
        holder.nombreProducto.setText(lista.get(position).getNombre());
        holder.descripcion.setText(lista.get(position).getDes());
        holder.email.setText("contacto: " + lista.get(position).getEmail());
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class VhOferta extends RecyclerView.ViewHolder {

        private TextView nombreProducto;
        private TextView descripcion;
        private TextView nombrePersona;
        private TextView email;

        public VhOferta(View itemView) {
            super(itemView);

            nombreProducto =  itemView.findViewById(R.id.txtNombreProducto);
            descripcion = itemView.findViewById(R.id.txtDescrip);
            nombrePersona = itemView.findViewById(R.id.txtNombrePersona);
            email = itemView.findViewById(R.id.idCorreoItem);
        }

        public TextView getNombreProducto() {
            return nombreProducto;
        }

        public TextView getDescripcion() {
            return descripcion;
        }

        public TextView getNombrePersona() {
            return nombrePersona;
        }
    }
}



package com.app.JuanCristobalJavier.applaescalera.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.JuanCristobalJavier.applaescalera.R;
import com.app.JuanCristobalJavier.applaescalera.model.Demanda;

import java.util.ArrayList;


/**
 * Created by Juan on 12/03/2018.
 */

public class AdaptadorDemandas extends RecyclerView.Adapter <AdaptadorDemandas.VhDemandas> implements View.OnClickListener{
    private View.OnClickListener listener;
    private ArrayList<Demanda> lista;

    public AdaptadorDemandas(ArrayList<Demanda> lista) {
        this.lista = lista;
    }

    @Override
    public VhDemandas onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demandas, parent, false);
        v.setOnClickListener(this);
        VhDemandas vh = new VhDemandas(v);
        return vh;    }

    @Override
    public void onBindViewHolder(VhDemandas holder, int position) {
        holder.nombrePersona.setText(lista.get(position).getNombreUsuario());
        holder.nombreProducto.setText(lista.get(position).getNombre());
        holder.descripcion.setText(lista.get(position).getDes());
        holder.emailItem.setText("contacto: " +lista.get(position).getEmail());
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


    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public class VhDemandas extends RecyclerView.ViewHolder {
        private TextView nombreProducto;
        private TextView descripcion;
        private TextView nombrePersona;
        private TextView emailItem;

        public VhDemandas(View itemView) {

            super(itemView);
            nombreProducto =  itemView.findViewById(R.id.txtNombreProductoD);
            descripcion = itemView.findViewById(R.id.txtDescripD);
            nombrePersona = itemView.findViewById(R.id.txtNombrePersonaD);
            emailItem = itemView.findViewById(R.id.idCorreoItem);
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

        public TextView getEmailItem() {
            return emailItem;
        }

        public void setEmailItem(TextView emailItem) {
            this.emailItem = emailItem;
        }
    }


}

package com.projectApp.JuanCristobalJavier.applaescalera.recyclerViewUtils;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.projectApp.JuanCristobalJavier.applaescalera.R;
import com.projectApp.JuanCristobalJavier.applaescalera.model.Chat;
import com.projectApp.JuanCristobalJavier.applaescalera.model.ChatActivity;

import java.util.ArrayList;

/**
 * Created by cristobal on 08/03/2018.
 */

public class AdaptadorChat extends RecyclerView.Adapter<AdaptadorChat.MiViewHolder> implements View.OnClickListener{

    private ArrayList<Chat> miChat;
    private View.OnClickListener listener;

    //¿Dónde se inicializa el arrayList?
    public AdaptadorChat(ChatActivity chatActivity, int item_chat, ArrayList<Chat> misChats) {
        this.miChat = misChats;
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
            imagen = (ImageView) view.findViewById(R.id.idImagenChat);
            textoSup = (TextView) view.findViewById(R.id.idTituloChat);
            textoInf = (TextView) view.findViewById(R.id.idTextoChat);
        }
    }
    @Override
    public AdaptadorChat.MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        v.setOnClickListener(this);
        AdaptadorChat.MiViewHolder vh = new MiViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(AdaptadorChat.MiViewHolder holder, int position) {
        holder.textoSup.setText(miChat.get(position).getUsuario());
        holder.textoInf.setText(miChat.get(position).getMensaje());
        holder.imagen.setImageResource(miChat.get(position).getImagen());
    }

    @Override
    public int getItemCount() {
        return miChat.size();
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

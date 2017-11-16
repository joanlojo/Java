package com.enti.joan.gincanaenti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sobre on 05/11/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    protected View.OnClickListener onClickListener;
    protected LayoutInflater inflador;             //Crea Layouts a partir de l'XML list_item
    protected Context contexto;                    //Necessari per l'inflater

    public Adaptador(Context _contexto) {
        this.contexto = _contexto;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //Creem el ViewHolder, amb els elements que cal mostrar

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Posem com a propietats tots els views que conté cada ítem de la llista
        public TextView descripcion;
        public TextView id;
        public TextView idNext;
        public TextView latitud;
        public TextView longitud;
        public ImageView imagen;
        public Spinner option;

        public ViewHolder(View itemView) {
            super(itemView);
            descripcion = (TextView)itemView.findViewById(R.id.des);
            id = (TextView)itemView.findViewById(R.id.id);
            idNext = (TextView)itemView.findViewById(R.id.idNext);
            latitud = (TextView)itemView.findViewById(R.id.latitud);
            longitud = (TextView)itemView.findViewById(R.id.longitud);
            imagen = (ImageView)itemView.findViewById(R.id.imageView);
            option = (Spinner)itemView.findViewById(R.id.spinner);
        }
    }
    //Mètode obligatori que genera un ViewHolder a partir de l'id de l'XML list_item

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.lista_items, null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);

    }
    //metodo para detectar el lcick sobre un elemento de la lista
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    // Mètode obligatori que ens permet especificar què posar als views de cada item

    @Override

    public void onBindViewHolder(ViewHolder holder, int posicio) {
        Pista p= listaPistas.obtenerP(posicio);
        holder.descripcion.setText("Descripcion: " + p.getDescripcion().toString());
        holder.id.setText(p.getId().toString());
        holder.idNext.setText(p.getIdNext().toString());
        holder.latitud.setText(Double.toString(p.getLatitud()));
        holder.longitud.setText(Double.toString(p.getLongitud()));
        // para la imagen, hacer tres ifs segun el spinner y poner la imagen
       if(holder.option.getSelectedItemPosition()==0){
           holder.imagen.setImageResource(R.mipmap.ic_image);
       }
        if(holder.option.getSelectedItemPosition()==1){
            holder.imagen.setImageResource(R.mipmap.ic_texto);
        }
        if(holder.option.getSelectedItemPosition()==2){
            holder.imagen.setImageResource(R.mipmap.ic_music);
        }


    }
    //Mètode obligatori que retorna el número d'elements total de la llista

    @Override public int getItemCount() {

        return listaPistas.getLength();
//END TO DO

    }

}
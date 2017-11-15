package com.enti.joan.gincanaenti;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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

//TO DO: assignar la llista de versions a la propietat

        //ens guardem una referència a la llista d'strings

//END TO DO



        inflador = (LayoutInflater) contexto

                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }





    //Creem el ViewHolder, amb els elements que cal mostrar

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Posem com a propietats tots els views que conté cada ítem de la llista
        EditText descripcion = (EditText)itemView.findViewById(R.id.des);
        EditText identificador = (EditText)itemView.findViewById(R.id.id);
        Spinner option = (Spinner)itemView.findViewById(R.id.spinner);
        EditText latitud = (EditText)itemView.findViewById(R.id.latitud);
        EditText longitud = (EditText)itemView.findViewById(R.id.longitud);
        EditText idnextPista = (EditText)itemView.findViewById(R.id.idNext);
        // (en aquest cas només un TextView per a guardar el nom de la versió

        public TextView nombreVersion;

        public ViewHolder(View itemView) {
            super(itemView);
            //TO DO: assignar a la propietat nomVersió el TextView que s'ha especificat al layout amb el seu ID
            nombreVersion = (TextView)itemView.findViewById(R.id.nombreVersion);
            //END TO DO
        }
    }
    //Mètode obligatori que genera un ViewHolder a partir de l'id de l'XML list_item

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.lista_items, null);
        v.setOnClickListener(onClickListener);
//creo la variables

        return new ViewHolder(v);

    }
    //metodo para detectar el lcick sobre un elemento de la lista
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    // Mètode obligatori que ens permet especificar què posar als views de cada item

    @Override

    public void onBindViewHolder(ViewHolder holder, int posicio) {
        //hago el view holder de cada
        Pista p= PistaGlobal.pistaL.obtenerP(posicio);
        holder.identificador.setText(p.getId().toString());
        holder.idnextPista.setText(p.getIdNext().toString());
        //holder.latitud.setText(p.getPosition().toString());
        holder.descripcion.setText(p.getPosition().toString());



    }



    //Mètode obligatori que retorna el número d'elements total de la llista

    @Override public int getItemCount() {

//TO DO: retornar el número d'elements de llistaVersions


        return PistaGlobal.pistaL.getLenght();
//END TO DO

    }

}